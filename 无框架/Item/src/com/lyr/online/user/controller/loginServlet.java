package com.lyr.online.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.online.entity.Personal;
import com.lyr.online.user.service.userService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String em = request.getParameter("email");
		String pwd = request.getParameter("password");
		userService userer = new userService();
		Personal p = userer.checkUser(em);
		if(p!=null&&p.getPassword().equals(pwd)){
			request.getSession().setAttribute("me",em);
			request.getRequestDispatcher("index").forward(request, response);
		}
		else if(p==null){
			request.getRequestDispatcher("noemail.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("passwordfail.jsp").forward(request, response);
		}
	}

}
