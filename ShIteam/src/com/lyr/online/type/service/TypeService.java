package com.lyr.online.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyr.online.entity.CakeType;
import com.lyr.online.type.dao.TypeDao;

@Service
@Transactional(readOnly=true)
public class TypeService {
	@Resource
	private TypeDao typedao;
	public List<CakeType> findTypeList(){
		return typedao.findPreType();
	}
	public CakeType findSinType(int mtnum){
		return typedao.findSinPreType(mtnum);
	}
}
