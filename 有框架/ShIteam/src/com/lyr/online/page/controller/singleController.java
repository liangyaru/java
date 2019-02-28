package com.lyr.online.page.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.entity.Cake;

@Controller
public class singleController {
	@Resource
	private CakeService cakeservice;
	@RequestMapping("/single")
	public String single(HttpServletRequest request,@RequestParam("scnum") int cnum){
		Cake sin = cakeservice.SingCakeInfor(cnum);
		request.getServletContext().setAttribute("mysinglecake",sin);
		return "single";
	}
}
