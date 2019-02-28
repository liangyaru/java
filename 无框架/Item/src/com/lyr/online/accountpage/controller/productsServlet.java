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
 * Servlet implementation class productsServlet
 */
@WebServlet("/products")
public class productsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productsServlet() {
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
		
		String typeNum = request.getParameter("ctnum");
		int ctnum = Integer.parseInt(typeNum);
		String pageNum=request.getParameter("pageNum");
		int num=0;
		if(pageNum==null || pageNum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pageNum);
		}
		CakeService lr = new CakeService();
		List<Cake> le = lr.prosore(ctnum,num);
		request.setAttribute("cakeshow", le);	
		
		String style = "type";
		request.setAttribute("mstyle", style);
		
		
		int count = lr.procakecount(ctnum);
		request.setAttribute("mcount", count);
		
		int total = Math.floorDiv(count,9)+1;
		request.setAttribute("mtotal", total);
				
		
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
