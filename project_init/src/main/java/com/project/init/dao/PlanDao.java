package com.project.init.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.project.init.dto.PlanDtDto;
import com.project.init.dto.PlanMstDto;

@Component
public class PlanDao implements PlanIDao {
	private static final Logger logger = LoggerFactory.getLogger(PlanDao.class);
	
	private final SqlSession sqlSession;

	// sqlSession ������ ����
	@Autowired
	public PlanDao (SqlSession sqlSession) {
		logger.info("PlanDao Const in >>>");
		this.sqlSession = sqlSession;
		
		logger.info("PlanDao Const result : sqlSession getConn success ? " + sqlSession.toString());
	}
	
	
	// ��� �̺�Ʈ ��������
	@Override
	public ArrayList<PlanMstDto> selectAllPlan(String userId) {
		logger.info("getCalendarEvent(" + userId + ") in >>>");

		ArrayList<PlanMstDto> dtos = (ArrayList)sqlSession.selectList("getCalendarEvent", userId);

		logger.info("getCalendarEvent(" + ") result : dtos.isEmpty() ? " + dtos.isEmpty());
		return dtos;
	}
	
	// planNum���� planMst �� ��������
	@Override
	public PlanMstDto selectPlanMst(String planNum, String userId) {
		logger.info("selectPlan (" + planNum + ") in >>>");
		
		PlanMstDto dto = new PlanMstDto();
		dto.setPlanNum(Integer.parseInt(planNum));
		dto.setUserId(userId);
		
		dto = sqlSession.selectOne("selectPlanMst", dto);
		
		logger.info("selectPlanMst(" + planNum + ") result : " + dto.getPlanNum());
		
		return dto;
	}

	
	// planNum���� planDt �� ��������
	@Override
	public ArrayList<PlanDtDto> selectPlanDt(String planNum, String userId) {
		logger.info("selectPlanDt (" + planNum + ") in >>> ");
		
		PlanDtDto dto = new PlanDtDto();
		dto.setPlanNum(Integer.parseInt(planNum));
		dto.setUserId(userId);
		
		ArrayList<PlanDtDto> result = (ArrayList)sqlSession.selectList("selectPlanDt", dto);

		logger.info("selectPlanDt (" +planNum + ") result ? " + result.isEmpty());
		
		return result;
	}
	
	// modalâ���� ������ ���� �ݿ� /* ��ȿ���� = 1.���� ���� ��� updateó�� */
	@Override
	@Transactional
	public String modifyPlanMst(HttpServletRequest request, String userId) {
		logger.info("modifyPlanMst in >>> ");
		String result = null;
		
		String originDateCount = request.getParameter("originDateCount");
		String newDateCount = request.getParameter("newDateCount");
		
		// planMst update : [����] �ٲ� ������ ������ ������ update �ݿ�
		PlanMstDto mstDto = planMstDtoParser(request, userId);
		mstDto.setDateCount(newDateCount);
		int res = sqlSession.update("updatePlanMst", mstDto);
		result = res > 0 ? "success": "failed";
		logger.info("modifyPlanMst result 1 : " + result);

		
		// �����Ǳ� �� dateCount		
		int origin = Integer.parseInt(originDateCount);
		// �����Ǳ� �� dateCount
		int newly = Integer.parseInt(newDateCount);

		List<PlanDtDto> updatePlanDt = new ArrayList<PlanDtDto>();
		
		// dateCount�� �۾������� (���� ���� �� - ���ο� ���� ��)��ŭ ���������� ����� ������ ��¥�� �ٲ���
		if ( origin > newly ) {
			// ���� �������� newly+1 ���� �������� ���� ex> origin 5�� , newly 2�� = 3��(newly+1)������ ��(origin)���� planDt����
			for (int i = (newly+1); i <= origin; i++) {
				PlanDtDto dtDto = new PlanDtDto();
				dtDto.setPlanNum(mstDto.getPlanNum());
				dtDto.setUserId(userId);
				dtDto.setPlanDay("day"+i);			

				
				int resDt = sqlSession.delete("deletePlanDt1", dtDto);
				result = resDt > 0 ? "success": "failed";
			}
			updatePlanDt = getUpdateDtos(mstDto.getPlanNum(), userId, mstDto.getStartDate(), newly);
		}		
		
		// date count�� ������ �� planDate�� ��¥�� �ٲ���
		else if ( origin == newly ) {
			updatePlanDt = getUpdateDtos(mstDto.getPlanNum(), userId, mstDto.getStartDate(), newly);				
		}
			
		// dateCount�� �� Ŀ������ ������ ���� �� ��ŭ�� �ٲ��ְ� ������ ���ڴ� �� ������ �����ؼ� insert
		else if ( origin < newly ) {
			// ���� ������ dateCount��ŭ ������ �迭�� ������
			updatePlanDt = getUpdateDtos(mstDto.getPlanNum(), userId, mstDto.getStartDate(), newly);
			
			//������ ���ڿ� ���� �� ������ ���� �迭
			ArrayList<PlanDtDto> nullPlanDt = new ArrayList<PlanDtDto>();
			
			// ���� ������ �ʰ��ϴ� ��ŭ�� nullPlanDt�� ��� ��ü �迭���� ������
			for(int i = (newly-1); i >= origin; i-- ) {
				updatePlanDt.get(i).setPlanDtNum(0);
				updatePlanDt.get(i).setTheme("�湮");
				updatePlanDt.get(i).setPlaceCount("0");
				
				nullPlanDt.add(updatePlanDt.get(i));
				updatePlanDt.remove(i);
			}
			
			int resDtSub = sqlSession.insert("insertNullDt", nullPlanDt);
			
			logger.info("modifyPlanMst result 3 nullDto insert : " + (resDtSub == 0 ? "success": "failed"));
		}
		
		System.out.println(updatePlanDt.get(0).getUserId());
		
		int resDt = sqlSession.update("updatePlanDt1", updatePlanDt);
		result = resDt == 0 ? "success": "failed";
		
		logger.info("modifyPlanMst result 2 : " + result);
	
		return result;
	}
	
	// modalâ���� ������ ���� �ݿ� /* ��ȿ���� = foreign key �����ϸ� �ذ� [ON DELETE CASCADE ENABLE] */
	@Override
	@Transactional
	public String deletePlan(String planNum, String userId) {
		logger.info("deletePlan(" + planNum + ") in >>>");

		String result = null;
		
		PlanMstDto dto = new PlanMstDto();
		dto.setPlanNum(Integer.parseInt(planNum));
		dto.setUserId(userId);
		
		// [PlanMst] - delete
		int res1 = sqlSession.delete("deletePlanMst", dto);
		result = res1 > 0 ? "success": "failed";
		logger.info("deletePlan(" + planNum + ") result1 : " + result);
		
		// [PlanDt] - delete
		int res2 = sqlSession.delete("deletePlanDt", dto);
		result = res2 > 0 ? "success": "failed";
		logger.info("deletePlan(" + planNum + ") result2 : " + result);

		return result;
	}
	
	
	// planDt insert
	@Override
	@Transactional
	public String insertPlanDtDo(HttpServletRequest request, String userId, Model model) {
		logger.info("insertPlanDtDo >>> ");
		
		String result = null;
		
		// request���� �Ѿ�� parameter�� planMstDto�� �Ľ��ϴ� �޼��� ����
		PlanMstDto mstDto = planMstDtoParser(request, userId);
		
		int res1 = sqlSession.insert("insertMst", mstDto);
		result = res1 > 0 ? "success": "failed";
		logger.info("insertPlanDtDo res1(Mst) : " + result);
		
		// request���� �Ѿ�� parameter�� planDtDto�� �Ľ��ϴ� �޼��� ����
		ArrayList<PlanDtDto> dtDtos = (ArrayList)planDtDtoParser(mstDto.getPlanNum(), userId, request);
		
		// �迭�� ������ insert ����
		int res2 = sqlSession.insert("insertDt", dtDtos);
		result = res2 > 0 ? "success": "failed";
		logger.info("insertPlanDtDo res2(Dt) : " + result);

		return result;
	}
	
	
	// planDt modify(update, delete, insert ���� �߻�) /* ��ȿ���� 1. ���� ���� ��� updateó���ϴ� �� */ 
	@Override
	@Transactional
	public String detailModifyDo(HttpServletRequest request, String userId) {
		logger.info("detailModifyDo() in >>> ");
	
		String result = null;
		
		// deleteDtNum : ������ ������ �ϳ��� ���� ��
		if(! request.getParameter("deleteDtNum").equals("") ) {
			logger.info("detailModifyDo deleteNum is exist");
			// parameter�� �Ѿ�� deleteDtNum�� '/'�� �����Ͽ� �迭�� ����
			String[] deleteDtNum = request.getParameter("deleteDtNum").split("/");
			
			List<PlanDtDto> deleteDtList = new ArrayList<PlanDtDto>();
			
			
			for ( int i = 0; i < deleteDtNum.length; i++ ) {
				System.out.println(deleteDtNum[i]);
				
				PlanDtDto dto = new PlanDtDto();
				dto.setUserId(userId);
				dto.setPlanDtNum(Integer.parseInt(deleteDtNum[i]));
				
				deleteDtList.add(dto);
			}
			// myBatis ���� ����
			int res = sqlSession.delete("deleteDt", deleteDtList);
			result = res == 1 ? "success": "failed";
		} else {
			logger.info("detailModifyDo deleteNum is null");
		}
		
		
		// ���� ���������� �Ѿ�� parameter parsing�ؼ� Dto��ü list ����
		int planNum = Integer.parseInt(request.getParameter("planNum"));
		ArrayList<PlanDtDto> dtos = (ArrayList)planDtDtoParser(planNum, userId, request);

		// ó���� query�� �����ؼ� ���� list ����
		ArrayList<PlanDtDto> insertDtos = new ArrayList<PlanDtDto>();
		ArrayList<PlanDtDto> updateDtos = new ArrayList<PlanDtDto>();
		
		// Dto�� ���� �ϳ��� update
		for ( int i = 0 ; i < dtos.size(); i++ ) {
	
			// planDtNum == 0 : ���� �߰��� �� �������� insert
			if ( dtos.get(i).getPlanDtNum() == 0 ) {
				insertDtos.add(dtos.get(i));
				
			// planDtNum != 0 : ������ �ִ� �� �������� update
			} else {
				updateDtos.add(dtos.get(i));
			}
		};
		
		if ( insertDtos.isEmpty() == false ) {	
			int res1 = sqlSession.insert("insertDt", insertDtos);
			result = res1== 1 ? "success": "failed";
		}
		if (updateDtos.isEmpty() == false ) {
			int res2 = sqlSession.update("updatePlanDt2", updateDtos);
			result = res2 == 1 ? "success": "failed";
		}
		
		return result;
	}
	
	//PlanMstDto�� �����ϴ� �޼���
	public PlanMstDto planMstDtoParser(HttpServletRequest request, String userId) {
		int planNum = Integer.parseInt(request.getParameter("planNum"));
		String planName = request.getParameter("planName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateCount = request.getParameter("dateCount");
		String eventColor = request.getParameter("eventColor");
		
		PlanMstDto mstDto = new PlanMstDto(planNum, userId, planName, startDate, endDate, dateCount, eventColor);
		
		return mstDto;
	}
	
	//PlanDtDto�� ����Ʈ�� �����ϴ� �޼���
	public List<PlanDtDto> planDtDtoParser(int planNum, String userId, HttpServletRequest request) {
		String[] planDtNum = request.getParameterValues("planDtNum");
		String[] placeName = request.getParameterValues("placeName");
		String[] placeCount = request.getParameterValues("placeCount");
		String[] planDay = request.getParameterValues("planDay");
		String[] planDate = request.getParameterValues("planDate");
		String[] startTime = request.getParameterValues("startTime");
		String[] endTime = request.getParameterValues("endTime");
		String[] theme = request.getParameterValues("theme");
		String[] latitude = request.getParameterValues("latitude");
		String[] longitude = request.getParameterValues("longitude");
		String[] address = request.getParameterValues("address");
		String[] category = request.getParameterValues("category");
		String[] transportation = request.getParameterValues("transportation");
		String[] details = request.getParameterValues("details");

		List<PlanDtDto> planDtDtos = new ArrayList<PlanDtDto>();
		
		for ( int i = 0 ; i < planDtNum.length; i++ ) {
			PlanDtDto dtDto = new PlanDtDto(Integer.parseInt(planDtNum[i]),
										  planNum,
										  userId,
										  placeName[i],
										  placeCount[i],
										  planDay[i],
										  planDate[i],
										  startTime[i],
										  endTime[i],
										  theme[i],
										  latitude[i],
										  longitude[i],
										  address[i],
										  category[i],
										  transportation[i],
										  details[i]);
			
			planDtDtos.add(dtDto);
		};
		
		return planDtDtos;
	}
	
	// modalâ���� ������ plan�� update�� ��ü �迭 ���� �޼���
	public List<PlanDtDto> getUpdateDtos(int planNum, String userId, String startDate, int dateCount) {
		List<PlanDtDto> dtos = new ArrayList<PlanDtDto>();
		
		// startDate Calendar ��ü�� ���� �۾�
		int y = Integer.parseInt(startDate.substring(0, 4));
		int m = Integer.parseInt(startDate.substring(5, 7)) - 1;;
		int d = Integer.parseInt(startDate.substring(8));
		
		Date date = new Date((y-1900), m, d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		for ( int i = 0; i < dateCount; i++ ) {
			if ( i == 0 ) {
				// Calendar ��ü�� �� startDate���� �Ϸ羿 �÷����鼭 planDate ����
				cal.add(Calendar.DATE, i);
			}
			// Calendar ��ü�� �� startDate���� �Ϸ羿 �÷����鼭 planDate ����
			cal.add(Calendar.DATE, 1);
			
			// planDate�� db ���˿� �°� ����
			String r = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			
			// planNum, planDay, planDate ���� ���� PlanDtDto�� ���� �迭�� ����
			PlanDtDto dtDto = new PlanDtDto();
			dtDto.setUserId(userId);
			dtDto.setPlanNum(planNum);
			dtDto.setPlanDay("day"+(i+1));
			dtDto.setPlanDate(r);
			
			dtos.add(dtDto);
		}
		
		return dtos;
		
	}
}
