package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class Prac {

	public static void main(String[] args) {
		UserInfo user  = new UserInfo();
		user.setUsername("����");
		user.setPassword("root");
		user.setNote("����Ա");
		
		int result = addUser(user);
		if(result>0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
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