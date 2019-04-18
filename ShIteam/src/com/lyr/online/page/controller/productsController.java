package com.lyr.online.page.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyr.online.cake.service.CakeService;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.type.service.TypeService;

@Controller
public class productsController {
	@Resource
	private TypeService typeservice;
	@Resource
	private CakeService cakeservice;
	@RequestMapping("/produ")
	public String produ(HttpServletRequest request,@RequestParam("pageNum") int pagenum){
		List<Cake> lz= this.cakeservice.AlCake(pagenum);
		int count = this.cakeservice.Allcount();
		int total = Math.floorDiv(count,9)+1;
		String style = "all";
		request.getServletContext().setAttribute("cakeshow", lz);
		request.getServletContext().setAttribute("mcount",count);
		request.getServletContext().setAttribute("mtotal", total);
		request.getServletContext().setAttribute("mstyle", style);
		return "products";
	}
	@RequestMapping("/pro")
	public String pro(HttpServletRequest request,@RequestParam("pageNum") int pagenum,
			@RequestParam(value="minsize",required=true,defaultValue="1") String minsizeNum,@RequestParam(value="maxsize",required=true,defaultValue="4") String maxsizeNum){
		int minsize = Integer.parseInt(minsizeNum);
		int maxsize = Integer.parseInt(maxsizeNum);
		List<Cake> lz= this.cakeservice.sizesore(minsize, maxsize, pagenum);
		int count = this.cakeservice.prosizecount(minsize, maxsize);
		int total = Math.floorDiv(count,9)+1;
		String style = "size";
		request.getServletContext().setAttribute("cakeshow", lz);
		request.getServletContext().setAttribute("mcount",count);
		request.getServletContext().setAttribute("mtotal", total);
		request.getServletContext().setAttribute("mstyle", style);
		request.getServletContext().setAttribute("myminsize", minsize);
		request.getServletContext().setAttribute("mymaxsize", maxsize);
		return "products";
	}
	@RequestMapping("/products")
	public String products(HttpServletRequest request,@RequestParam("pageNum") int pagenum,
			@RequestParam("ctnum") int ctnum){
		List<CakeType> lc = this.typeservice.findTypeList();
		Set<Cake> mChildCake =  this.typeservice.findSinType(ctnum).getChildCakes();
		Iterator<Cake> s =  mChildCake.iterator();
		List<Cake> le = new ArrayList<Cake>();
		int count = mChildCake.size();
		int minindex = (pagenum-1)*9;
		int maxindex;
		if(minindex+9<=count){
			maxindex = minindex+9;
		}else{
			maxindex = count;
		}
		for(int i=minindex;i<maxindex;i++){
			if(s.hasNext()){
				le.add(s.next());
			}
		}
		int total = Math.floorDiv(count,9)+1;
		String style = "type";
		request.getServletContext().setAttribute("cakelist",lc);
		request.getServletContext().setAttribute("cakeshow", le);
		request.getServletContext().setAttribute("mcount",count);
		request.getServletContext().setAttribute("mtotal", total);
		request.getServletContext().setAttribute("mstyle", style);
		return "products";
	}
}
