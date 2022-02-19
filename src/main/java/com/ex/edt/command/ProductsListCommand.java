package com.ex.edt.command;

import org.springframework.web.servlet.ModelAndView;

import com.ex.edt.DAO.ProductDAO;

public class ProductsListCommand implements Command {
	ProductDAO pDao;
	
	@Override
	public void execute(ModelAndView mv) {
		pDao = new ProductDAO();
		mv.addAttribute("pVos", pDao.getProductsList(mv.));
	}

}
