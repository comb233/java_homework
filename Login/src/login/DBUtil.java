package login;

import java.sql.*;

public class DBUtil {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/loginuser?user=root&password=123456");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return conn;
	}
}
