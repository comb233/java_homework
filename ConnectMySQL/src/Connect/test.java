package Connect;

import java.sql.*;
public class test {
public static void main (String [] args) {
try {
Class.forName(“com.mysql.jdbc.Driver”);
} catch (ClassNotFoundException e) {
System.out.println(“加载数据库驱动时抛出异常，内容如下： “);
e.printStackTrace();
}
try {
Connection conn = DriverManager.getConnection(“jdbc:mysql://localhost:3306/test”,”root”,”123456”);//这个地方，使用了刚刚创建的test数据库
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(“select * from info”);
while (rs.next()) {
System.out.println(“姓名：”+rs.getString(“name”)+”\t”+”ID”+rs.getString(“id”));
}
rs.close();
stmt.close();
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
