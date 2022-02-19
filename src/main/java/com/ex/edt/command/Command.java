package com.ex.edt.command;

import org.springframework.web.servlet.ModelAndView;

public interface Command {

	public void execute(ModelAndView mv);
}
