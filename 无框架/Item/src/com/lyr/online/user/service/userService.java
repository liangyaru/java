package com.lyr.online.user.service;

import java.util.List;
import com.lyr.online.entity.Personal;
import com.lyr.online.user.dao.userDao;

public class userService {
	public void addinfor(Personal p) {
		userDao userd = new userDao();
		userd.insertInfor(p);
	}	
	public List<String> ChaekEmail() {
		userDao userd = new userDao();
		return userd.findEmail();
	}
	public Personal checkUser(String em) {
		userDao userd = new userDao();
		return userd.selectInUser(em);
	}	
}


