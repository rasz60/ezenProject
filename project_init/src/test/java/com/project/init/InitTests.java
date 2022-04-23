package com.project.init;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.project.init.dao.PlanDao;
import com.project.init.dao.PostIDao;
import com.project.init.dto.PostDtDto;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class InitTests {

	@Autowired
	public PostIDao podao;
	
	
	@Test
	public void test() {
		String lat = "37.5455744";
		String lng = "126.8350976";
		
	}
	
}
