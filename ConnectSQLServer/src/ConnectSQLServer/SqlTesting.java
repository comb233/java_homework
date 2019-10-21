package ConnectSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlTesting {
	public static void main(String[] args) {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=STUDENT1";
		String userName = "sa";
		String userPwd = "123456";
		String kongge=new String(" ");
		//为后面的结果集输出好看点
		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try {
			Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("连接数据库成功！");
			Statement stmt=dbConn.createStatement();
			//创建SQL语句,实现对数据库的操作功能
			ResultSet rs=stmt.executeQuery("select * from 学生1");
			//返回查询的结果
			while(rs.next())
			{
			System.out.print(rs.getString("学号")+kongge);
			System.out.print(rs.getString("姓名")+kongge);
			System.out.print(rs.getString("身份证号")+kongge);
			System.out.print(rs.getString("性别")+kongge);
			System.out.print(rs.getString("备注")+kongge);
			System.out.println();
			}//输出结果集的内容
			rs.close();
			stmt.close();
			dbConn.close();
			//关闭语句,结果集,数据库的连接.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}
	}

}