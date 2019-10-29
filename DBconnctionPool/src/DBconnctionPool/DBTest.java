package DBconnctionPool;
import java.sql.Connection;

public class DBTest {
	public static void main(String[] args) {
        DBconnectionManager manager=DBconnectionManager.getInstance();
        manager.init();
        Connection connection=manager.getConnection("sqlserver");
        System.out.println(connection.toString());
    }
}
