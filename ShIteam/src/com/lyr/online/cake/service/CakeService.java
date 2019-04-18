package com.lyr.online.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyr.online.cake.dao.CakeDao;
import com.lyr.online.entity.Cake;
import com.lyr.online.entity.Uorder;

@Service
@Transactional(readOnly=true)
public class CakeService {
	@Resource
	private CakeDao cakedao;
	public List<Cake> cakesore(){
		return this.cakedao.soreByStar();
	}
	public String Maxdc(){
		return this.cakedao.maxCake();
	}
	public List<Cake> Maxdisc(){
		return this.cakedao.maxDiscountCake();
	}
	public List<Cake> AlCake(int num){
		return this.cakedao.AllCake(num);
	}
	public int Allcount(){
		return this.cakedao.countAll();
	}
	public List<Cake> sizesore(int minsize,int maxsize,int num){
		return this.cakedao.checkBySize(minsize, maxsize, num);
	}
	public int prosizecount(int minsize,int maxsize){
		return this.cakedao.countkBySize(minsize, maxsize);
	}
	public List<Cake> prosore(int ctnum,int num){
		return this.cakedao.checkByType(ctnum, num);
	}
	public int procakecount(int ctnum){
		return this.cakedao.countkByType(ctnum);
	}
	public Cake SingCakeInfor(int cnum){
		return this.cakedao.singleCake(cnum);
	}
	public void addCart(Uorder uorder){
		this.cakedao.personaladdCake(uorder);
	}
	public int AllcountUor(){
		return this.cakedao.countAllOrder();
	}
}
