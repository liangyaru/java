package com.lyr.online.cart.service;

import java.util.List;

import com.lyr.online.cart.dao.addDao;
import com.lyr.online.entity.DisplayCake;
import com.lyr.online.entity.Orderdetails;
import com.lyr.online.entity.Uorder;

public class addService {
	public int orderCount(){
		addDao addda = new addDao();
		return addda.ucount();
	}
	public int orderdetailCount(){
		addDao addda = new addDao();
		return addda.dcount();
	}	
	public void addorder(Uorder o){
		addDao addda = new addDao();
		addda.insertorder(o);
	}
	public void addorderdetail(Orderdetails t){
		addDao addda = new addDao();
		addda.insertorderdetails(t);
	}
	public List<DisplayCake> checkMyCart(String em){
		addDao addda = new addDao();
		return addda.checkCart(em);
	}
}
