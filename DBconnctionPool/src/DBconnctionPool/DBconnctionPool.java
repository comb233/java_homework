package DBconnctionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class DBconnctionPool {
	private int inuserd;
	private int maxConn;
	private int minConn;
	private String poolName;
	ArrayList freeConnections=new ArrayList();
	private String username;
	private String password;
	private String url;
	private String driver;
	
	public DBconnctionPool(int maxConn, String username, String password,
	        String url, String driver) {
	    super();
	    this.maxConn = maxConn;
	    this.username = username;
	    this.password = password;
	    this.url = url;
	    this.driver = driver;
	}
	
	public synchronized void freeConnection(Connection conn){
	    freeConnections.add(conn);
	    inuserd--;
	}
	
	public Connection createConnection() {
	    Connection conn = null;
	    try {
	        Class.forName(driver);
	        conn = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        System.out.println("sorry,can't find the driver");
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        System.out.println("can't connect...");
	    }
	    return conn;
	}
	
	public synchronized Connection getConnection()
	 {
	  Connection con=null;
	  if(this.freeConnections.size()>0)
	  {
	   con=(Connection)this.freeConnections.get(0);
	   this.freeConnections.remove(0);//如果连接分配出去了，就从空闲连接里删除
	   if(con==null)con=getConnection(); //继续获得连接
	  }
	  else
	  {
	   con=createConnection(); //新建连接
	  }
	  if(this.maxConn==0||this.maxConn<this.inuserd)
	  {
	   con=null;//等待 超过最大连接时
	  }
	  if(con!=null)
	  {
	   this.inuserd++;
	   System.out.println("得到　"+this.poolName+"　的连接，现有"+inuserd+"个连接在使用!");
	  }
	  return con;
	 }
	
	public synchronized void release(){
	    Iterator allconns=freeConnections.iterator();
	    while(allconns.hasNext()){
	        Connection conn=(Connection) allconns.next();
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    //移除集合里的所有元素
	    freeConnections.clear();
	}
	
	
}
