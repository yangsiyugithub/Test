package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class Prac2 {

	public static void main(String[] args) {
		
		/*
		//1添加
		 UserInfo user  = new UserInfo();
		user.setUsername("李四");
		user.setPassword("111");
		user.setNote("用户");
		
		int result = addUser(user);
		if(result>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}*/
		/*
		//2.删除
		int result = delUser(6);
		if(result>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}*/
	
		
	//	3.修改
		UserInfo user  = new UserInfo();
		user.setUsername("Tom");
		
		user.setId(2);
		user.setNote("用户");
		user.setPassword("000");
		
		int result = updateUser(user);
		
		if(result>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
		
		
		/*//34.
		UserInfo user = getUserById(4);
		System.out.println(user);*/
		}
				//1.添加数据
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
	}
	
				
				//修改数据
				public  static int updateUser(UserInfo user){
					int result = 0;
					Connection conn = null;
					Statement stm = null;
					
					try{
						conn = DBUtil.getConnection();
						stm = conn.createStatement();
						String sql="update  userinfo set userName='"+user.getUsername()+"',password='"+user.getPassword()+"',password = "+user.getId()+" where id="+user.getId();
						result = stm.executeUpdate(sql);
					}catch(Exception ex){
						ex.printStackTrace();
					}finally{
						DBUtil.close(conn, stm, null);
					}
					return result;
				}
				
				//删除数据
				public static int delUser(int id){
					int result = 0;
					Connection conn = null;
					Statement stm = null;
					
					try{
						conn = DBUtil.getConnection();
						stm = conn.createStatement();
						String sql = "delete from userinfo where id="+id;
						result = stm.executeUpdate(sql);
					}catch(Exception ex){
						ex.printStackTrace();
					}finally{
						DBUtil.close(conn, stm, null);
					}
					
					return result;
				}
				
				//根据id查询用户
				public static UserInfo getUserById(int id) {
					UserInfo user = null;
					
					Connection conn = null;
					Statement stm = null;
					ResultSet rs = null;
					
					try {
						conn = DBUtil.getConnection();
						stm = conn.createStatement();
						String sql = "select * from userinfo where id="+id;
						rs = stm.executeQuery(sql);
						if(rs.next()) {
							user = new UserInfo();
							user.setId(rs.getInt("id"));
							user.setUsername(rs.getString("userName"));
							user.setPassword(rs.getString("password"));
							user.setNote(rs.getString("note"));
						}
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}finally {
						DBUtil.close(conn, stm, rs);
					}
						
					return user;
				}


	}


