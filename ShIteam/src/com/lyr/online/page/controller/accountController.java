package com.lyr.online.page.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class accountController {
	@RequestMapping("/account")
	public String account(HttpServletRequest request){
		return "account";
	}
}
