package login;
import login.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginForm {
    private String name;
    private String pwd;
	
	public void init() {
		System.out.println("请输入您的账号及密码：");
		Scanner input = new Scanner(System.in);
		name = input.nextLine();
		pwd = input.nextLine();
	}
	
	public void display() {
		System.out.println("您输入的账号，密码分别是："+name+","+pwd);
	}
	
	public void validate() throws ClassNotFoundException, SQLException {
		UserDAO user = new UserDAO();
		if(user.findUser(name, pwd))
			System.out.println("登陆成功！");
		else
			System.out.println("登陆失败！");
	}
}
