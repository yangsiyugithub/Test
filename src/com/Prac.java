package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class Prac {

	public static void main(String[] args) {
		UserInfo user  = new UserInfo();
		user.setUsername("李四");
		user.setPassword("root");
		user.setNote("管理员");
		
		int result = addUser(user);
		if(result>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
}
	public static int addUser(UserInfo user){
		int result = 0;
		Connection conn = null;
		Statement stm = null;
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.createStatement();
			String sql = "insert into userinfo(userName,password,note) values('"+user.getUsername()+"','"+user.getPassword()+"',"+user.getNote()+")";
			result = stm.executeUpdate(sql);
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, null);
		}
		
		return result ;
	}}