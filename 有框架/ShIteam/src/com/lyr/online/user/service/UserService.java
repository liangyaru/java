package com.lyr.online.user.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lyr.online.entity.Personal;
import com.lyr.online.user.dao.UserDao;
@Service
@Transactional(readOnly=false)
public class UserService {
	@Resource
	private UserDao userdao;
	public void addinfor(Personal p){
		userdao.insertInfor(p);
	}
	public List<String> ChaekEmail(){
		return userdao.findEmail();
	}
	public Personal checkUser(String em) {
		return userdao.selectInUser(em);
	}
}
