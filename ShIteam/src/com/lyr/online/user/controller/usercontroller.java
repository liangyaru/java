package com.lyr.online.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyr.online.entity.Personal;
import com.lyr.online.user.service.UserService;

@Controller
public class usercontroller {
	@Resource
	private UserService userservice;
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request,@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,@RequestParam("email_address") String email_address,
			@RequestParam("pwd") String pwd,@RequestParam("cpwd") String cpwd){
		Date date = new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String registime = sdf.format(date);
		Personal p = new Personal();
		p.setEmail(email_address);
		p.setFirst_name(first_name);
		p.setLast_name(last_name);
		p.setPassword(pwd);
		p.setRegistertime(registime);
		List<String> le = userservice.ChaekEmail();
		int flag = 0;
		for(String e:le){
			if(e.equals(email_address)){
				flag = 1;
				break;
			}
		}
		if(pwd.equals(cpwd) && flag==0){
			userservice.addinfor(p);
			return "redirect:/index";
		}
		else if(flag==1)
		{
			return "eamilfail";
		}
		else{
			return "pwdfail";
		}		
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,@RequestParam("email") String em,
			@RequestParam("password") String pwd){
		Personal p = userservice.checkUser(em);
		if(p!=null&&p.getPassword().equals(pwd)){
			request.getSession().setAttribute("me",em);
			return "index";
		}
		else if(p==null){
			return "noemail";
		}else{
			return "passwordfail";
		}	
	}
	
}
