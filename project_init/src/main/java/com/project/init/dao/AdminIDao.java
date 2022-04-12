package com.project.init.dao;

import java.util.ArrayList;
import java.util.Map;

import com.project.init.dto.PlanDtDto;
import com.project.init.dto.UserDto;

public interface AdminIDao {
	// ��� �� ���	
	ArrayList<PlanDtDto> selectDashBoardPlaces(Map<String, String> map);
	
	// �⵵,��,�� �� ȸ���� ���
	ArrayList<UserDto> selectDashBoardUser(Map<String, String> map);
	
	// ȸ�� ���� ���
	ArrayList<UserDto> selectDashBoardUserGender();
	
	// ȸ�� ���ɺ� ���
	ArrayList<UserDto> selectDashBoardUserAge();
}