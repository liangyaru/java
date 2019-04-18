package com.lyr.online.cake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyr.online.entity.Cake;
import com.lyr.online.util.LinkDb;

public class soreCakeDao {
	public List<Cake>soreByTag(){
		List<Cake> lp= new ArrayList<Cake>(); 
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake order by star desc,discount desc limit 0,8";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Cake cake = new Cake();
				cake.setBigpic(rs.getString("bigpic"));
				cake.setPrice(rs.getInt("price"));
				cake.setStar(rs.getInt("star"));
				cake.setName(rs.getString("name"));
				lp.add(cake);
			}
			ln.closeCon(conn);
			return lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String maxCake(){
		String s=null;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select bigpic from cake order by price desc limit 0,1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				s = rs.getString("bigpic");
			}
			ln.closeCon(conn);
			return  s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Cake> maxDiscountCake(){
		List<Cake> lp= new ArrayList<Cake>(); 
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake order by discount limit 0,2";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Cake cake = new Cake();
				cake.setBigpic(rs.getString("bigpic"));
				cake.setPrice(rs.getInt("price"));
				cake.setStar(rs.getInt("star"));
				cake.setName(rs.getString("name"));
				lp.add(cake);
			}
			ln.closeCon(conn);
			return  lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Cake> checkByType(int ctnum,int num){
		List<Cake> lp= new ArrayList<Cake>(); 
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake where type=? limit ?,9";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ctnum);
			pstmt.setInt(2,(num-1)*9);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Cake cake = new Cake();
				cake.setCnum(rs.getInt("cnum"));
				cake.setName(rs.getString("name"));
				cake.setPrice(rs.getInt("price"));
				cake.setDiscount(rs.getInt("discount"));
				cake.setBigpic(rs.getString("bigpic"));
				cake.setType(rs.getInt("type"));
				lp.add(cake);
			}
			ln.closeCon(conn);
			return  lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int countkByType(int ctnum){
		int count = 0;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake where type=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,ctnum);
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
	public List<Cake> checkBySize(int minsize,int maxsize,int num){
		List<Cake> lp= new ArrayList<Cake>(); 
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake where size between ? and ? limit ?,9";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,minsize);
			pstmt.setInt(2,maxsize);
			pstmt.setInt(3,(num-1)*9);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Cake cake = new Cake();
				cake.setCnum(rs.getInt("cnum"));
				cake.setName(rs.getString("name"));
				cake.setPrice(rs.getInt("price"));
				cake.setDiscount(rs.getInt("discount"));
				cake.setBigpic(rs.getString("bigpic"));
				lp.add(cake);
			}
			ln.closeCon(conn);
			return  lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int countkBySize(int minsize,int maxsize){
		int count = 0;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake where size between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,minsize);
			pstmt.setInt(2,maxsize);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
			ln.closeCon(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  count;
	}
	public List<Cake> AllCake(int num){
		List<Cake> lp= new ArrayList<Cake>(); 
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake limit ?,9";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,(num-1)*9);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Cake cake = new Cake();
				cake.setCnum(rs.getInt("cnum"));
				cake.setName(rs.getString("name"));
				cake.setPrice(rs.getInt("price"));
				cake.setDiscount(rs.getInt("discount"));
				cake.setBigpic(rs.getString("bigpic"));
				lp.add(cake);
			}
			ln.closeCon(conn);
			return  lp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int countAll(){
		int count = 0;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
			ln.closeCon(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  count;
	}
	public Cake singleCake(int cnum){
		Cake cake = new Cake();
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from cake where cnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,cnum);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				cake.setCnum(rs.getInt("cnum"));
				cake.setName(rs.getString("name"));
				cake.setDescription(rs.getString("description"));
				cake.setSize(rs.getInt("size"));
				cake.setStar(rs.getInt("star"));
				cake.setPrice(rs.getInt("price"));
				cake.setDiscount(rs.getInt("discount"));
				cake.setBigpic(rs.getString("bigpic"));
				cake.setSmallpic1(rs.getString("smallpic1"));
				cake.setSmallpic2(rs.getString("smallpic2"));
				cake.setSmallpic3(rs.getString("smallpic3"));
				cake.setBigpic(rs.getString("bigpic"));
				cake.setTag(rs.getString("tag"));
				cake.setType(rs.getInt("type"));
				cake.setDiscount(rs.getInt("discount"));
			}
			ln.closeCon(conn);
			return cake;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String tnumBytype(int type){
		String s = null;
		LinkDb ln = new LinkDb();
		Connection conn = ln.getConnection();
		PreparedStatement pstmt=null;
		try {
			String sql = "select * from caketype where tnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,type);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				s = rs.getString("name");
			}
			ln.closeCon(conn);
			return s;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
