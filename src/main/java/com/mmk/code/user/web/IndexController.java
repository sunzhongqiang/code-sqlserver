package com.mmk.code.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class IndexController {

	@RequestMapping("/")
	public ModelAndView name() {
		return new ModelAndView(new RedirectView("/codeUI/index.html"));
	}
}
