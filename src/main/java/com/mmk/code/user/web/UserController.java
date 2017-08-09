package com.mmk.code.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.code.common.SessionUtils;

@RestController
public class UserController {

	@RequestMapping("/user/sign")
	public String sign(String username){
		SessionUtils.getSession().setAttribute("username", username);
		return "SUCCESS";
	}
}
