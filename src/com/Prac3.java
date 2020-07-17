package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import util.DBUtil;

public class Prac3 {
			
			public static void main(String[] args) {
					
				/*Scanner scan = new Scanner(System.in);
					System.out.println("请输入用户名：");
					String userName = scan.nextLine();
					System.out.println("请输入密码：");
					String password  = scan.nextLine();
					
					UserInfo user = getLogin(userName,password);
					if(user ==null){
						System.out.println("登陆失败");
					}else{
						System.out.println("登陆成功");
					}
			}*/
				UserInfo user = new UserInfo();
				user.setUsername("王五");
				user.setBirthday(new Date());
				int result = addUserInfo(user);
				}
			public static int addUserInfo(UserInfo user){
				Connection conn = null;
				PreparedStatement stm = null;
				int result = 0;
				
				try {
					conn = DBUtil.getConnection();
					String sql="insert into userinfo(userName,password,note,birthday) values(?,?,?,?)";
					stm = conn.prepareStatement(sql);
					stm.setString(1, user.getUsername());
					stm.setString(2, user.getPassword());
					stm.setString(3, user.getNote());
					stm.setDate(4,new java.sql.Date(user.getBirthday().getTime()));   
					result = stm.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.close(conn, stm, null);
				}
				
				return result;
			}
				/*public static UserInfo getLogin(String userName,String password){
					UserInfo user = null;
					Connection conn = null;
					PreparedStatement stm = null;   
					ResultSet rs = null;
					
					try {
						conn = DBUtil.getConnection();
						String sql = "select * from userinfo where userName = ? and password=?";  
						stm = conn.prepareStatement(sql);  
						stm.setString(1, userName);  
						stm.setString(2, password); 
						rs = stm.executeQuery();   
						if(rs.next()){
							user = new UserInfo();
							user.setUsername(rs.getString("userName"));
							user.setPassword(rs.getString("password"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} finally{
						DBUtil.close(conn, stm, rs);
					}
					return user;
				}		*/	
			}

