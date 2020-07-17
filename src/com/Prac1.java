package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBUtil;

public class Prac1 {

	public static void main(String[] args) throws Exception {
					
					Connection conn =DBUtil.getConnection();
					Statement stm=conn.createStatement();
					String sql = "select * from userinfo";
					ResultSet rs=stm.executeQuery(sql);
					   
					while(rs.next()){
						int id=rs.getInt(1);
						String username=rs.getString("username");
						String password=rs.getString("password");
						String note=rs.getString("note");
						System.out.println("id:"+id+";"+"username:"+username+";"+"password:"+password+";"+"note:"+note);	
					}
					
					DBUtil.close(conn, stm, rs);
	}

}
