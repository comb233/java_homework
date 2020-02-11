package login;

import login.DBUtil;
import java.sql.*;


public class UserDAO {
    
	
	public boolean findUser(String userName,String userPassword) throws ClassNotFoundException, SQLException {
		
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		
		//然后创建statement类对象，用来执行SQL语句
		Statement statement=con.createStatement();
		//你要执行的Sql语句
		String sql="select username,password from user";
		//最后设置Resultset类，用来存放获取的结果集
		ResultSet rs=statement.executeQuery(sql);

		//System.out.println("执行结果如下：");
		//System.out.println("姓名"+"\t"+"密码");

		while(rs.next()) {

		String uname=rs.getString("username");
		String pwd=rs.getString("password");
        if(uname.equals(userName) && pwd.equals(userPassword)) {
        	//System.out.println(uname+",登陆成功！");
        	return true;
           }
		}
        
		//最后关闭
		rs.close();
		con.close();
		
		return false;
	}
}
