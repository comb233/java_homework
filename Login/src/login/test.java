package login;

import java.sql.*;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根

		Connection conn = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/loginuser?user=root&password=123456");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		//然后创建statement类对象，用来执行SQL语句
		Statement statement=conn.createStatement();
		//你要执行的Sql语句
		String sql="select username,password from user";
		//最后设置Resultset类，用来存放获取的结果集
		ResultSet rs=statement.executeQuery(sql);

		System.out.println("执行结果如下：");
		System.out.println("姓名"+"\t"+"密码");

		while(rs.next()) {

		String uname=rs.getString("username");
		String pwd=rs.getString("password");

		System.out.println(uname+"\t"+pwd);
		}

		//最后关闭
		rs.close();
		conn.close();

	}

}
