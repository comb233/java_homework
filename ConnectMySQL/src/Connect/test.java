package Connect;

import java.sql.*;
public class test {
public static void main (String [] args) {
try {
Class.forName(��com.mysql.jdbc.Driver��);
} catch (ClassNotFoundException e) {
System.out.println(���������ݿ�����ʱ�׳��쳣���������£� ��);
e.printStackTrace();
}
try {
Connection conn = DriverManager.getConnection(��jdbc:mysql://localhost:3306/test��,��root��,��123456��);//����ط���ʹ���˸ոմ�����test���ݿ�
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(��select * from info��);
while (rs.next()) {
System.out.println(����������+rs.getString(��name��)+��\t��+��ID��+rs.getString(��id��));
}
rs.close();
stmt.close();
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
