package DBPool;

import java.sql.Connection;
import java.sql.DriverManager;



public class SQLServerHandler {
	private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbURL = "jdbc:sqlserver://LAPTOP-0DIPPF30:1433;DatabaseName=SQLTest";
	private static final String dbUsername = "sa";
	private static final String Password = "123456";
	private Connection conn = null;
	
	public Connection buildConnection() {
		try {
			Class.forName(jdbcDriver);
			this.conn = DriverManager.getConnection(dbURL, dbUsername, Password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
		return conn;
	}
}
