package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnection {
	
	
	
	private static final String URL = "jdbc:sqlserver://LAPTOP-0DIPPF30:1433;DatabaseName=SQLTest";
	
	private static final String NAME = "sa";
	
	private static final String PASSWORD = "123456";
	
	private static String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	Connection conn = null;
	public Connection getConnection() throws SQLException {
		
		try {
			
			Class.forName(jdbcName); 
			System.out.println("鍔犺浇椹卞姩鎴愬姛锛�");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("鍔犺浇椹卞姩澶辫触");
		}
		
		try {
			
			conn = DriverManager.getConnection(URL,NAME,PASSWORD);
			System.out.println("鑾峰彇鏁版嵁搴撹繛鎺ユ垚鍔燂紒");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("鑾峰彇鏁版嵁搴撹繛鎺ュけ璐ワ紒");
		}
		return conn;
	}
	
	
	public ResultSet listDB() throws SQLException {
		String sql = "select sno,sname from student";
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) throws SQLException {
		SQLConnection sqlserver = new SQLConnection();
		Connection con= sqlserver.getConnection();
		ResultSet rest = sqlserver.listDB();
		System.out.println("鏁版嵁搴揝QLTest涓璼tudent琛ㄧ殑濮撳悕锛�");
		try {
			while(rest.next()) {
				System.out.println(rest.getString(1));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	
	}
}
