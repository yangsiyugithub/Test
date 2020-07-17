package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class Prac4 {

	public static void main(String[] args) {
		List<UserInfo> userlist = getList(null,null,null);
		for(UserInfo user :userlist){
			System.out.println(user);
		}
	}
	public static List<UserInfo> getList(String userName,String password,String note){
		List<UserInfo> userlist = new ArrayList<UserInfo>();
		UserInfo user =null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs =null;
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.createStatement();
			String sql= "select * from userinfo where 1=1";
			
			if(!(userName == null || "".equals(userName))){
				sql += " and userName like '%"+userName+"%' ";
			}
			if(!(password == null || "".equals(password))){
				sql += " and password like '%"+password+"%' ";
			}
			if(!(note == null || "".equals(note))){
				sql += " and note like '%"+note+"%' ";
			}
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery(sql);
			while(rs.next()){
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNote(rs.getString("note"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, rs);
		}
		return userlist;
	}

}
