package com.ex.edt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ex.edt.DAO.ProductDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EdtController {
	ProductDAO pDao;
	private static final Logger logger = LoggerFactory.getLogger(EdtController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home() {
		System.out.println("gotoMAIN()");
		return "main";
	}
	
	@RequestMapping(value = "/draw", method=RequestMethod.GET)
	public String draw(Model model) {
		System.out.println("gotoDRAW()");
		return "draw";
	}
	
	@RequestMapping(value = "/products")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView();
		System.out.println("gotoPRODUCTS()");
		mv.addObject("pVos", pDao.getProductsList("", "", ""));
		mv.setViewName("products");
		return mv;
	}

	@RequestMapping(value = "/join")
	public String join(Model model) {
		System.out.println("gotoJOIN()");
		return "join";
	}
}
