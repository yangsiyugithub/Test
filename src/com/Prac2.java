package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class Prac2 {

	public static void main(String[] args) {
		
		/*
		//1���
		 UserInfo user  = new UserInfo();
		user.setUsername("����");
		user.setPassword("111");
		user.setNote("�û�");
		
		int result = addUser(user);
		if(result>0) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}*/
		/*
		//2.ɾ��
		int result = delUser(6);
		if(result>0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}*/
	
		
	//	3.�޸�
		UserInfo user  = new UserInfo();
		user.setUsername("Tom");
		
		user.setId(2);
		user.setNote("�û�");
		user.setPassword("000");
		
		int result = updateUser(user);
		
		if(result>0) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
		
		
		/*//34.
		UserInfo user = getUserById(4);
		System.out.println(user);*/
		}
				//1.�������
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
	
				
				//�޸�����
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
				
				//ɾ������
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
				
				//����id��ѯ�û�
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


