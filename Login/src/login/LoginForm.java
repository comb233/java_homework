package login;
import login.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginForm {
    private String name;
    private String pwd;
	
	public void init() {
		System.out.println("�����������˺ż����룺");
		Scanner input = new Scanner(System.in);
		name = input.nextLine();
		pwd = input.nextLine();
	}
	
	public void display() {
		System.out.println("��������˺ţ�����ֱ��ǣ�"+name+","+pwd);
	}
	
	public void validate() throws ClassNotFoundException, SQLException {
		UserDAO user = new UserDAO();
		if(user.findUser(name, pwd))
			System.out.println("��½�ɹ���");
		else
			System.out.println("��½ʧ�ܣ�");
	}
}
