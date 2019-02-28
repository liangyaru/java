package com.lyr.online.cake.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.entity.Personal;
import com.lyr.online.entity.Uorder;

@Repository
public class CakeDao {
	@Resource
	private SessionFactory sessionFactory;
	public List<Cake> soreByStar(){
		String sql = "from Cake as c order by c.star desc,c.discount desc";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setMaxResults(8);
		List<Cake> list = q.list();
		return list;
	}
	public String maxCake(){
		String sql = "select c.bigpic from Cake as c where c.star = 8";
		Session session = this.sessionFactory.getCurrentSession();
		String q = (String)session.createQuery(sql).uniqueResult();
		return q;
	}
	public List<Cake> maxDiscountCake(){
		String sql = "from Cake as c order by c.discount";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setMaxResults(2);
		List<Cake> list = q.list();
		return list;
	}
	public List<Cake> AllCake(int num){
		String sql = "from Cake as c";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setFirstResult((num-1)*9);
		q.setMaxResults(9);
		List<Cake> list = q.list();
		return list;
	}
	public int countAll(){
		String sql = "select max(c.cnum) from Cake as c";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		int count = (int)session.createQuery(sql).uniqueResult();
		return count;
	}
	public List<Cake> checkBySize(int minsize,int maxsize,int num){
		String sql = "from Cake as c where c.size between"+" "+minsize+"and"+" "+maxsize;
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setFirstResult((num-1)*9);
		q.setMaxResults(9);
		List<Cake> list = q.list();
		return list;
	}
	public int countkBySize(int minsize,int maxsize){
		String sql = "from Cake as c where c.size between"+" "+minsize+"and"+" "+maxsize;
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		int count = q.list().size();
		return count;
	}
	public List<Cake> checkByType(int ctnum,int num){
		String sql = "from Cake as c where c.type=:caketype";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setParameter("caketype",ctnum);
		q.setFirstResult((num-1)*9);
		q.setMaxResults(9);
		List<Cake> list = q.list();
		return list;
	}
	public int countkByType(int ctnum){
		String sql = "select max(c.cnum) from Cake as c where c.cnum=:cakenum";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		int count = (int)session.createQuery(sql).uniqueResult();
		return count;
	}
	public Cake singleCake(int cnum){
		String sql = "from Cake as c where c.cnum=:cakenum";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		q.setParameter("cakenum",cnum);
		Cake ca = (Cake)q.uniqueResult();
		return ca;
	}
	public void personaladdCake(Uorder uorder){
		Session session = this.sessionFactory.openSession();;
		Transaction tx = session.beginTransaction();
		session.save(uorder);
		tx.commit();
	}
	public int countAllOrder(){
		String sql = "select max(u.onum) from Uorder as u";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		int count = (int)session.createQuery(sql).uniqueResult();
		return count;
	}
}
