package login;

import java.sql.SQLException;

import login.LoginForm;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自动生成的方法存根
        LoginForm login = new LoginForm();
        login.init();
        login.display();
        login.validate();
	}

}
