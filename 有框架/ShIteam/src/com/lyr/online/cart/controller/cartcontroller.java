package com.lyr.online.cart.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.Personal;
import com.lyr.online.entity.Uorder;
import com.lyr.online.user.service.UserService;
@Controller
public class cartcontroller {
	@Resource
	private CakeService cakeservice;
	@Resource
	private UserService userservice;
	@RequestMapping("/addcart")
	public String addcart(HttpServletRequest request,@RequestParam("cakenum") int cnum){
		if(request.getSession().getAttribute("me")!=null){
			Cake c = this.cakeservice.SingCakeInfor(cnum);
			Uorder muorder = new Uorder();
			Date date = new Date();
			SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String addtime = sdf.format(date);
			muorder.setOnum(this.cakeservice.AllcountUor()+1);
			muorder.setTime(addtime);
			muorder.setState("addCart");
			muorder.setUser((String)request.getSession().getAttribute("me"));
			muorder.getChildcake().add(c);
			this.cakeservice.addCart(muorder);
			return "redirect:/single?scnum="+cnum;
		}else{
			return "addLogin";
		}
	}
	@RequestMapping("/check")
	public String check(HttpServletRequest request){
		if(request.getSession().getAttribute("me")!=null){
			Personal p = this.userservice.checkUser((String)request.getSession().getAttribute("me"));
			List<Uorder> personalorder = new ArrayList<Uorder>();
			<Uorder> s =p.getChildUorders().iterator();
			while(s.hasNext()){
				personalorder.add(s.next());
			}
			List<Cake> ld = new ArrayList<Cake>();
			for(Uorder u:personalorder){
				Iterator<Cake> sc = u.getChildcake().iterator();
				while(sc.hasNext()){
					ld.add(sc.next());
				}
			}
			request.getServletContext().setAttribute("mcart",ld);
			request.getServletContext().setAttribute("mcartsize",ld.size());
			return "checkout";
		}else{
			return "addLogin";
		}
	}
}
