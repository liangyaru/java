package com.lyr.online.page.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.type.service.TypeService;


@Controller
public class indexController {
	@Resource
	private TypeService typeservice;
	@Resource
	private CakeService cakeservice;
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		List<CakeType> lc = this.typeservice.findTypeList();
		request.getServletContext().setAttribute("cakelist",lc);
		List<Cake> c = this.cakeservice.cakesore();
		request.getServletContext().setAttribute("indexcake",c);
		String cm = this.cakeservice.Maxdc();
		request.getServletContext().setAttribute("mymaxpic", cm);
		List<Cake> ld = this.cakeservice.Maxdisc();
		request.getServletContext().setAttribute("mycake", ld);
		return "index";
	}
}
