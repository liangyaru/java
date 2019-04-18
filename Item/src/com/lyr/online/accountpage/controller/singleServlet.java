package com.lyr.online.accountpage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.type.service.ListService;

/**
 * Servlet implementation class singleServlet
 */
@WebServlet("/single")
public class singleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public singleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListService ls = new ListService();
		List<CakeType> lc = ls.findAllCake();
		request.setAttribute("cakelist",lc);
		String scnum = request.getParameter("scnum");
		int cnum = Integer.parseInt(scnum);
		
		CakeService le = new CakeService();
		Cake sin = le.SingCakeInfor(cnum);
		request.setAttribute("mysinglecake", sin);
		request.setAttribute("typename", le.typename(sin.getType()));
		
		
		
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
