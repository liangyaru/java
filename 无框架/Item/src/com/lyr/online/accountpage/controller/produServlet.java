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
 * Servlet implementation class produServlet
 */
@WebServlet("/produ")
public class produServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produServlet() {
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
		
		String pagesizeNum=request.getParameter("pageNum");
		int num=0;
		if(pagesizeNum==null || pagesizeNum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pagesizeNum);
		}
		CakeService lr = new CakeService();
		List<Cake> lz = lr.AllCake(num);
		request.setAttribute("cakeshow", lz);
		
		int count = lr.Allcount();
		request.setAttribute("mcount",count);
		int total = Math.floorDiv(count,9)+1;
		request.setAttribute("mtotal", total);
		String style = "all";
		request.setAttribute("mstyle", style);
		
		
		
		
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
