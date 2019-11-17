package DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseTest {
	static MyDatabaseConnection SQLPool =new SQLServerPool();
	public static void main(String[] args) {
		
		//浣跨敤杩炴帴姹�
		SQLPool.init();
		long start = System.currentTimeMillis();
		for(int i=0; i<5000; i++) {
			test();
		}
		long end = System.currentTimeMillis();
		System.out.println("缁忚繃5000娆″惊鐜皟鐢紝浣跨敤杩炴帴姹犺姳璐圭殑鏃堕棿锛�" + (end-start) + "ms");
		
	
		SQLServerHandler handler = new SQLServerHandler();
		long start2 = System.currentTimeMillis();
		for(int i=0; i<50; i++) {
			try {
				Connection conn = handler.buildConnection();
				String sql = "select * from student";
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				//System.out.println(rs);
				pst.close();
				conn.close(); 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		long end2 = System.currentTimeMillis();
		System.out.println("缁忚繃50娆＄殑寰幆璋冪敤锛屼笉浣跨敤杩炴帴姹犺姳璐圭殑鏃堕棿锛�" + (end2-start2) + "ms");
		
	}
	private static void test() {
		try {
			Connection conn = SQLPool.getConnection();
			String sql = "select * from student";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			pst.close();
			
			SQLPool.close(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
