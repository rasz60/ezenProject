package com.project.init.command;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.init.dao.PlanDao;
import com.project.init.dto.PlanMstDto;

public class PlanMstSelectCommand implements ICommand {
	
	private static final Logger logger = LoggerFactory.getLogger(PlanMstInsertCommand.class);
	
	@Autowired
	private PlanDao planDao;
		
	@Override
	public void execute(HttpServletRequest request, Model model) {
		logger.info("execute() in >>> ");
				
		PlanMstDto dto = planDao.selectPlanMst((Integer)request.getAttribute("planNum"));
		
		model.addAttribute("mstDto", dto);
	}

}