package com.lyr.online.type.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lyr.online.entity.CakeType;
import com.lyr.online.util.LinkDb;


public class CakeTypedao {
	List<CakeType> lc= new ArrayList<CakeType>(); 
	public List<CakeType> findAll(){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select *  from caketype");
			while(rs.next()){
				CakeType c = new CakeType();
				c.setTnum(rs.getInt("tnum"));
				c.setName(rs.getString("name"));
				c.setState(rs.getInt("state"));
				c.setPrenum(rs.getInt("prenum"));
				lc.add(c);
			}
			return lc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
