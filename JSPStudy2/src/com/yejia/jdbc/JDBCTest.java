package com.yejia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
//	取得数据库连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
//			Class封装的是被装载到JVM中的类的信息，类的成员方法、成员变量、以及类实现的接口、父类等等；forName方法用来初始化参数指定的类，并创建一个对应的实例对象
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "root");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
//	插入数据
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "INSERT INTO tbl_user(name, password, email)" +
		"VALUES('Tom', '123456', 'tom@gmail.com')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向用户表中插入了 " + count + "条记录");
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	更新方法
	public static void update(){
		Connection conn = getConnection();
		try {
			String sql = "UPDATE tbl_user SET email='tom@126.com' WHERE name = 'Tom'";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向用户表中更新了 " + count + "条记录");
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	删除记录方法
	public static void delete(){
		Connection conn = getConnection();
		try {
			String sql = "DELETE FROM tbl_user WHERE name = 'Tom'";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向用户表中删除了 " + count + "条记录");
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
//		String sql = "SELECT * FROM tbl_user";
//		Connection conn = null;
//		Statement st = null;
//		ResultSet rs = null;
//		
//		try {
////			Class封装的是被装载到JVM中的类的信息，类的成员方法、成员变量、以及类实现的接口、父类等等；forName方法用来初始化参数指定的类，并创建一个对应的实例对象
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "root");
//			
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()){
//				System.out.print(rs.getInt("id"));
//				System.out.print(rs.getString("name"));
//				System.out.print(rs.getString("password"));
//				System.out.print(rs.getString("email"));
//				System.out.println();
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			
//			try {
//				rs.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			try {
//				st.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			try {
//				conn.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
		
//		insert();
//		update();
		delete();
	}
}
