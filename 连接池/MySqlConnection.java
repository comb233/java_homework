package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection {
	
	private static final String URL = "jdbc:mysql://127.0.1:3306/R_L?serverTimezone=CTT";
	
	private static final String NAME = "root";
	
	private static final String PASSWORD = "123456";

	private static String jdbcName = "com.mysql.cj.jdbc.Driver";
	public void TheSqlConnection() {
		
		try {
			Class.forName(jdbcName);
			System.out.println("鍔犺浇椹卞姩鎴愬姛!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("鍔犺浇椹卞姩澶辫触锛�");
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,NAME,PASSWORD);
			System.out.println("鑾峰彇鏁版嵁搴撹繛鎺ユ垚鍔燂紒");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("鑾峰彇鏁版嵁搴撹繛鎺ュけ璐ワ紒");
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				conn = null;
			}
		}
	}
}
