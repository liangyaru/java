package com.lyr.online.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.online.entity.Personal;
import com.lyr.online.user.service.userService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_address = request.getParameter("email_address");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		Date date = new Date();
		Personal p = new Personal();
		p.setEmail(email_address);
		p.setFirst_name(first_name);
		p.setLast_name(last_name);
		p.setPassword(pwd);
		p.setRegistertime(date);
		userService userser = new userService();
		List<String> le= userser.ChaekEmail();
		int flag = 0;
		for(String e:le){
			if(e.equals(email_address)){
				flag = 1;
				break;
			}
		}
		if(pwd.equals(cpwd) && flag==0){
			userser.addinfor(p);
			request.getRequestDispatcher("index").forward(request, response);
		}
		else if(flag==1)
		{
			request.getRequestDispatcher("eamilfail.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("pwdfail.jsp").forward(request, response);
		}

	}

}
