package login;

import login.DBUtil;
import java.sql.*;


public class UserDAO {
    
	
	public boolean findUser(String userName,String userPassword) throws ClassNotFoundException, SQLException {
		
		DBUtil db = new DBUtil();
		Connection con = db.getConnection();
		
		//Ȼ�󴴽�statement���������ִ��SQL���
		Statement statement=con.createStatement();
		//��Ҫִ�е�Sql���
		String sql="select username,password from user";
		//�������Resultset�࣬������Ż�ȡ�Ľ����
		ResultSet rs=statement.executeQuery(sql);

		//System.out.println("ִ�н�����£�");
		//System.out.println("����"+"\t"+"����");

		while(rs.next()) {

		String uname=rs.getString("username");
		String pwd=rs.getString("password");
        if(uname.equals(userName) && pwd.equals(userPassword)) {
        	//System.out.println(uname+",��½�ɹ���");
        	return true;
           }
		}
        
		//���ر�
		rs.close();
		con.close();
		
		return false;
	}
}
