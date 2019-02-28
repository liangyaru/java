package com.lyr.online.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lyr.online.entity.Cake;
import com.lyr.online.entity.CakeType;
import com.lyr.online.entity.Personal;
import com.lyr.online.user.service.userService;
import com.lyr.online.util.LinkDb;
import com.lyr.online.util.TimeFormat;

public class userDao {
	List<String> lp= new ArrayList<String>(); 
	public void insertInfor(Personal p){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			TimeFormat timeform = new TimeFormat();
			String s = timeform.SetTimeFormat().format(p.getRegistertime());
			String sql = "insert into personal values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,p.getEmail());
			pstmt.setString(2,p.getFirst_name());
			pstmt.setString(3,p.getLast_name());
			pstmt.setString(4,s);
			pstmt.setString(5,p.getPassword());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> findEmail(){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select email  from personal");
			while(rs.next()){
				lp.add(rs.getString("email"));
			}
			return lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public Personal selectInUser(String em){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		Personal p = null ;
		try {
			pstmt = conn.prepareStatement("select email,password from personal where email=?");
			pstmt.setString(1,em);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				p = new Personal();
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	

}
