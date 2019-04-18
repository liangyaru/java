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
 * Servlet implementation class proServlet
 */
@WebServlet("/pro")
public class proServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public proServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListService ls = new ListService();
		List<CakeType> lc = ls.findAllCake();
		request.setAttribute("cakelist",lc);
				
		String minsizeNum = request.getParameter("minsize");
		String maxsizeNum = request.getParameter("maxsize");
		int minNum = Integer.parseInt(minsizeNum);
		int maxNum = Integer.parseInt(maxsizeNum);
		String pagesizeNum=request.getParameter("pageNum");
		int num=0;
		if(pagesizeNum==null || pagesizeNum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pagesizeNum);
		}
		CakeService lr = new CakeService();
		List<Cake> lz = lr.sizesore(minNum,maxNum,num);
		request.setAttribute("cakeshow", lz);
		
		int count = lr.prosizecount(minNum,maxNum);
		request.setAttribute("mcount",count);
		int total = Math.floorDiv(count,9)+1;
		request.setAttribute("mtotal", total);
		String style = "size";
		request.setAttribute("mstyle", style);
		request.setAttribute("myminsize",minsizeNum);
		request.setAttribute("mymaxsize",maxsizeNum);
		
		
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

}
