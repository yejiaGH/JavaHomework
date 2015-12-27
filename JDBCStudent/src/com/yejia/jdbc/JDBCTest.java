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
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?characterEncoding=utf8", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
//	打印结果集
	public static void printResult(String sql){
		
		Connection conn = getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {			
			st = conn.createStatement();
			rs = st.executeQuery(sql);			
			
			while(rs.next()){
				System.out.print(rs.getString("stu_id"));
				System.out.print(" | ");
				System.out.print(rs.getString("stu_name"));
				System.out.print(" | ");
				System.out.print(rs.getInt("stu_age"));
				System.out.print(" | ");
				System.out.print(rs.getString("stu_gender"));
				System.out.print(" | ");
				System.out.print(rs.getString("stu_address"));
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
//	向学生表插入10条数据
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "INSERT INTO t_students(stu_id, stu_name, stu_age, stu_gender, stu_address)" + 
		"VALUES('s001','叶佳',20,'女','上海市浦东新区世纪大道100号'),"+
		"('s002','周鸥',21,'男','上海市浦东新区世纪大道101号'),"+
		"('s003','李明',14,'男','上海市浦东新区世纪大道102号'),"+
		"('s004','王菲',12,'女','上海市浦东新区世纪大道103号'),"+
		"('s005','周迅',21,'男','上海市浦东新区世纪大道104号'),"+
		"('s006','王勃',15,'男','上海市浦东新区世纪大道105号'),"+
		"('s007','章子怡',29,'女','上海市浦东新区世纪大道106号'),"+
		"('s008','汪峰',31,'男','上海市浦东新区世纪大道107号'),"+
		"('s009','李亚鹏',33,'男','上海市浦东新区世纪大道108号'),"+
		"('s010','白百合',14,'女','上海市浦东新区世纪大道109号')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向学生表中插入了 " + count + "条记录");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
//	更新操作
	public static void delete(String sql){
		Connection conn = getConnection();
		try {
			
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("向学生表中删除了 " + count + "条记录");
		conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		清除表数据
		System.out.println("清除表数据");
		String sql_clear = "DELETE FROM t_students";
		delete(sql_clear);
//		插入10条学生记录
		System.out.println("插入10条学生记录");
		insert();
//		输出表数据
		String sql = "SELECT * FROM t_students";
		printResult(sql);
//		查询年龄大于15岁的男生，并将数据输出 
		System.out.println("查询年龄大于15岁的男生");
		String sql_query = "SELECT * FROM t_students WHERE stu_age > 15 AND stu_gender='男'";
		printResult(sql_query);
//		删除所有男生的数据
		System.out.println("删除所有男生的数据");
		String sql_delete = "DELETE FROM t_students WHERE stu_gender = '男'";
		delete(sql_delete);
		printResult(sql);
	}
}
