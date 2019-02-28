package com.lyr.online.cake.service;

import java.util.List;

import com.lyr.online.cake.dao.soreCakeDao;
import com.lyr.online.entity.Cake;

public class CakeService {
	public List<Cake> cakesore(){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.soreByTag();
	}
	public String Maxdc(){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.maxCake();
	}
	public List<Cake> Maxdisc(){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.maxDiscountCake();
	}
	public List<Cake> prosore(int ctnum,int num){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.checkByType(ctnum,num);
	}
	public int procakecount(int ctnum)
	{
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.countkByType(ctnum);
	}
	public List<Cake> sizesore(int minsiaze,int maxsize,int num){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.checkBySize(minsiaze,maxsize,num);
	}
	public int prosizecount(int minsize,int maxsize)
	{
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.countkBySize(minsize,maxsize);
	}
	public List<Cake> AllCake(int num){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.AllCake(num);
	}
	public int Allcount()
	{
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.countAll();
	}
	public Cake SingCakeInfor(int cnum){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.singleCake(cnum);
	}
	public String typename(int type){
		soreCakeDao soreCakeDao = new soreCakeDao();
		return soreCakeDao.tnumBytype(type);
	}
	
}
