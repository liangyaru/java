package com.lyr.online.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyr.online.cake.dao.soreCakeDao;
import com.lyr.online.entity.DisplayCake;
import com.lyr.online.entity.Orderdetails;
import com.lyr.online.entity.Uorder;
import com.lyr.online.util.LinkDb;

public class addDao {
	public int ucount(){
		int count = 0;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from uorder";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
			ln.closeCon(conn);
			return  count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public int dcount(){
		int count = 0;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from orderdetails";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
			ln.closeCon(conn);
			return  count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public void insertorderdetails(Orderdetails t){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "insert into orderdetails values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,t.getDnum());
			pstmt.setInt(2,t.getOnum());
			pstmt.setInt(3,t.getCnum());
			pstmt.setInt(4,t.getNumber());
			pstmt.setInt(5,t.getRprice());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertorder(Uorder o){
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "insert into uorder(onum,time,user,state) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,o.getOnum());
			pstmt.setString(2,o.getTime());
			pstmt.setString(3,o.getUser());
			pstmt.setString(4,o.getState());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<DisplayCake> checkCart(String em){
		List<DisplayCake> ld = new ArrayList<DisplayCake>();
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from uorder,orderdetails  where user=? and uorder.onum=orderdetails.onum";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,em);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				DisplayCake cake = new DisplayCake();
				cake.setTime(rs.getString("time"));
				cake.setCnum(rs.getInt("cnum"));
				ld.add(cake);
			}
			ln.closeCon(conn);	
			return ld;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
