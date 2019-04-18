package com.lyr.online.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.cart.service.addService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.entity.DisplayCake;
import com.lyr.online.entity.Orderdetails;
import com.lyr.online.entity.Uorder;
import com.lyr.online.type.service.ListService;

/**
 * Servlet implementation class checkServlet
 */
@WebServlet("/check")
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("me")!=null){
			ListService ls = new ListService();
			List<CakeType> lc = ls.findAllCake();
			request.setAttribute("cakelist",lc);
			
			addService la = new addService();
			String em = (String)request.getSession().getAttribute("me");
			List<DisplayCake> ld = la.checkMyCart(em);
			request.getSession().setAttribute("cartcake",ld);
			for(DisplayCake d:ld){
				Cake c= new CakeService().SingCakeInfor(d.getCnum());
				d.setBigpic(c.getBigpic());
				d.setName(c.getName());
				d.setRprice(c.getPrice());
				d.setDiscount(c.getDiscount());
			}
			request.setAttribute("mcart",ld);
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("addLogin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
