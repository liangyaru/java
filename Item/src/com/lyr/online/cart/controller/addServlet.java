package com.lyr.online.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.cart.service.addService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.Orderdetails;
import com.lyr.online.entity.Uorder;
import com.lyr.online.util.TimeFormat;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addcart")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("me")!=null){
			String cakenum = request.getParameter("cakenum");
			int cnum = Integer.parseInt(cakenum);
			CakeService le = new CakeService();
			Cake cake = le.SingCakeInfor(cnum);
			Uorder o = new Uorder();
			addService la = new addService();
			int onum = la.orderCount();
			o.setOnum(onum+1);
			Date date = new Date();
			TimeFormat timeform = new TimeFormat();
			String s = timeform.SetTimeFormat().format(date);
			o.setTime(s);
			String user = (String)request.getSession().getAttribute("me");	
			o.setUser(user);			
			o.setState("addCart");
			la.addorder(o);
				
//			int qty = Integer.parseInt(request.getParameter("quantity"));
			int dnum = la.orderdetailCount();
			Orderdetails orderdetail = new Orderdetails();
			orderdetail.setDnum(dnum+1);
			orderdetail.setOnum(onum+1);
			orderdetail.setCnum(cnum);
			orderdetail.setNumber(1);
			orderdetail.setRprice(cake.getDiscount()*cake.getPrice()/10);
			
			la.addorderdetail(orderdetail);
			request.getRequestDispatcher("single?scnum="+cnum).forward(request, response);
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
