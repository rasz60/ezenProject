package com.project.init.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.project.init.dao.UserDao;
import com.project.init.util.Constant;

public class ModifyPwCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		UserDao udao = Constant.udao;
		
		String uId = null;
		
		if ( request.getParameter("mail") != null || request.getParameter("mail") != "" ) {
			uId = request.getParameter("mail");
		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User)authentication.getPrincipal();
			uId = user.getUsername();
		}
		
		String Npw = request.getParameter("npw");
		
		String Npw_org = Npw; //��ȣȭ �Ǳ��� password�� Npw_org�� ����
		Npw = passwordEncoder.encode(Npw_org); //��ȣȭ
		System.out.println(Npw + " size " + Npw.length());
		
		System.out.println(uId + " : " + Npw);
		
		
		String result = udao.modifyPw(Npw, uId);
		
		request.setAttribute("result", result); //controller���� ��� ���
	}

}
