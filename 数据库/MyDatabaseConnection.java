package DBPool;

import java.sql.Connection;


public interface IDatabaseConnection {
	
	public void init();
	
	public Connection getConnection();
	
	public void close(Connection conn);
}
