package com.lyr.online.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkDb {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		String sql="jdbc:mysql://127.0.0.1:3306/item?useUnicode=true&characterEncoding=UTF-8";
		Connection conn;
		try {
			conn = DriverManager.getConnection(sql,"root","");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public static void closeCon(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
