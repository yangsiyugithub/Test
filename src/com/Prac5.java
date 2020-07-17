package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class Prac5 {

	public static void main(String[] args) {
		//clobdemo();
		//clobReaddemo();
		readImageBlob();
		//getImageFormDB();
		System.out.println("yes,ok!");

	}
	public static void clobdemo() {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into text(title,content) values(?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1,"标题一");
			Reader r = new FileReader("D:/dinah.txt");
			stm.setCharacterStream(2, r);
			stm.executeUpdate();
			r.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,stm,null);
		}
	}
	public static void clobReaddemo() {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from text where title = '标题二'";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("title"));
				Reader r = rs.getCharacterStream("content");
				BufferedReader br = new BufferedReader(r);
				BufferedWriter bw = new BufferedWriter(new FileWriter("D:/prac.txt"));
				String str = null;
				while((str =br.readLine()) !=null) {
					bw.write(str);
					bw.newLine();
					bw.flush();
				}
				br.close();
				bw.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,stm,rs);
		}
	}
	public static void readImageBlob() {
		Connection conn = null;
		PreparedStatement stm = null;
	
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into text(title,photo) values(?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1,"标题三");
			InputStream in= new FileInputStream("D:/dinah.jpg");
			stm.setBinaryStream(2, in);
			stm.executeUpdate();
			
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,stm,null);
		}
	}
	public static void getImageFormDB() {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into text(title,content) values(?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1,"标题一");
			Reader r = new FileReader("D:/dinah.txt");
			stm.setCharacterStream(2, r);
			stm.executeUpdate();
			r.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,stm,null);
		}
	}
}
