package login;

import java.sql.*;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO �Զ����ɵķ������

		Connection conn = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/loginuser?user=root&password=123456");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		//Ȼ�󴴽�statement���������ִ��SQL���
		Statement statement=conn.createStatement();
		//��Ҫִ�е�Sql���
		String sql="select username,password from user";
		//�������Resultset�࣬������Ż�ȡ�Ľ����
		ResultSet rs=statement.executeQuery(sql);

		System.out.println("ִ�н�����£�");
		System.out.println("����"+"\t"+"����");

		while(rs.next()) {

		String uname=rs.getString("username");
		String pwd=rs.getString("password");

		System.out.println(uname+"\t"+pwd);
		}

		//���ر�
		rs.close();
		conn.close();

	}

}
