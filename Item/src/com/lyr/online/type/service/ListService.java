package com.lyr.online.type.service;

import java.util.List;

import com.lyr.online.entity.CakeType;
import com.lyr.online.type.dao.CakeTypedao;

public class ListService {
	public List<CakeType> findAllCake(){
		CakeTypedao caketypedao = new CakeTypedao();
		return caketypedao.findAll();
	}
}
