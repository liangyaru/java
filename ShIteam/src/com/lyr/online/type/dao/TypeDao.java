package com.lyr.online.type.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lyr.online.entity.CakeType;

@Repository
public class TypeDao {
	@Resource
	private SessionFactory sessionFactory;
	public List<CakeType> findPreType(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CakeType c where c.state = 0");
		return q.list();
	}
	public CakeType findSinPreType(int mtnum){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CakeType c where c.tnum =:mtnum");
		q.setParameter("mtnum",mtnum);
		CakeType ct = (CakeType)q.uniqueResult();
		return ct;
	}
}
