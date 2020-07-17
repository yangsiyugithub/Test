package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
		private DBUtil() {}
			private static String driver = "com.mysql.jdbc.Driver";
			private static String url = "jdbc:mysql://localhost:3306/test";
			private static String user = "root";
			private static String password = "root";
			
		
		static {
			try {
				Class.forName(driver);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//创建连接
		public static Connection getConnection() {
			Connection coon = null;
			try {
				coon = DriverManager.getConnection(url, user, password);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return coon;
		}
		//关闭连接
		public static void close(Connection conn,Statement stm,ResultSet rs){
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stm !=null){
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs !=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
		}