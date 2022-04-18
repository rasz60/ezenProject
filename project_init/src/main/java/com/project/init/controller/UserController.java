package com.project.init.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.init.command.ICommand;
import com.project.init.command.JoinCommand;
import com.project.init.dao.UserDao;
import com.project.init.util.Constant;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserDao udao;
	@Autowired
	public void setUdao(UserDao udao) {
		this.udao = udao;
		Constant.udao = udao;
	}
	
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	private ICommand mcom;
	
	@RequestMapping("/user/join_view")
	public String join() {
		logger.info("join_view() in >>> ");
		return "join/join";
	}
	
	@RequestMapping(value = "/user/join", method=RequestMethod.POST, produces = "application/text; charset=UTF8")
	@ResponseBody
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("join() in >>> ");
		
		mcom = new JoinCommand();
		mcom.execute(request, model);
		
		String result = (String) request.getAttribute("result");
		System.out.println(result);
		
		logger.info("join() result : " + result);
		
		if(result.equals("success"))
			return "join-success";
		else
			return "join-failed";
	}
	
	@RequestMapping(value="/user/emailCheck")  //占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙占� 占싫듸옙?
	@ResponseBody
	public int emailCheck(@RequestParam("id") String id) {
		logger.info("emailCheck(" + id + ") in >>> ");
		
		int res = udao.emailCheck(id);
		
		logger.info("emailCheck(" + id + ") result : " + (res > 0 ? "success": "false"));
		return res;
	}
	
	@RequestMapping(value="/user/nickCheck")
	@ResponseBody
	public int nickCheck(@RequestParam("nick") String nick) {
		logger.info("nickCheck(" + nick + ") in >>> ");
		
		int res = udao.nickCheck(nick);
		
		logger.info("emailCheck(" + nick + ") result : " + (res > 0 ? "success": "false"));
		return res;
	}
	/*
	// 권한 없는 사용자가 url로 페이지 접근시 처리하려고 했으나 적용 안됨.. 
	@RequestMapping("/needLogin")
	public String needLogin(RedirectAttributes rttr) {
		logger.info("needLogin() in >>> ");
		
		rttr.addFlashAttribute("needlogin", "로그인이 필요합니다.");

		logger.info("needLogin() result : needLogin");
		
		return "redirect:/";
	}
	*/
	
	@RequestMapping(value="/processLogin")
	public String processLogin(@RequestParam(value="error", required = false) String error, 
							   @RequestParam(value="logout", required = false) String logout, 
							   HttpServletRequest request, HttpServletResponse response,
							   Model model, RedirectAttributes rttr) {
		
		logger.info("processLogin() in >>> ");

		if(error != null && error !="") {
			rttr.addFlashAttribute("error", "아이디나 비밀번호가 잘못되었습니다.");
			logger.info("processLogin() result : error");
		}
		
		if(logout != null && logout != "") {
			logger.info("processLogin() result : logout");
		}
		
		
		return "redirect:/";
	}
	
	//占싸깍옙占쏙옙 占쏙옙占쏙옙占쏙옙
	@RequestMapping(value="/loginSuc")
	public String loginSuc(Authentication authentication, RedirectAttributes rttr) {
		logger.info("loginSuc() in >>> ");
		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String uId = user.getUsername();

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String auth = authorities.toString(); //role占쏙옙 占쏙옙底� 占쏙옙占쌘울옙占쏙옙 占쏙옙환

		udao.userVisit(uId); //占싸깍옙占쏙옙 占쏙옙짜 占쏙옙占쏙옙占쏙옙트
		
		rttr.addAttribute("login", uId);
		
		logger.info("loginSuc() userAuth : " + auth);
		
		return "redirect:/";
	}
	
}