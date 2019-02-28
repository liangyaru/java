package com.lyr.online.user.dao;



import java.util.List;

import javax.annotation.Resource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.lyr.online.entity.Personal;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;
	public void insertInfor(Personal p){
		Session session = this.sessionFactory.openSession();;
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}
	public List<String> findEmail(){
		String sql = "select p.email from Personal as p";
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery(sql);
		List<String> list = q.list();
		return list;
	}
	public Personal selectInUser(String em){
		String sql = "from Personal as p where email=:memail";
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		query.setParameter("memail",em);
		Personal p = (Personal)query.uniqueResult();
		return p;
	}
}
