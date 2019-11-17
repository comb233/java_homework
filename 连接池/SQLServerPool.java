package DBPool;

import java.sql.Connection;
import java.util.LinkedList;


public class SQLServerPool implements IDatabaseConnection{
	
	private static final int minCount = 1;
	
	private static final int maxCount = 10;
	
	private static final LinkedList<Connection> pools = new LinkedList<Connection>();
	SQLServerHandler handler = new SQLServerHandler();
	
	
	public void init() {
		Connection conn = null;
		try {
			for(int i=0; i<minCount; i++) {
				conn = handler.buildConnection();
				pools.add(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public synchronized Connection getConnection() {
		Connection conn = null;
		if(pools.size() == 0) {
			conn = handler.buildConnection();
		}else {
			conn = pools.remove(0);
		}
		return conn;
	}
	
	
	public synchronized void close(Connection conn) {
	
		if(pools.size() < maxCount) {
			pools.add(conn);
		}
		//System.out.println(pools);
	}
}

