package DBconnctionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数据库连接池管理类
 * @author abcd
 *
 */
public class DBconnectionManager {
	public int clients;//客户的连接数
    static private DBconnectionManager instance;//唯一的连接池管理类实例
    HashMap<String,DBconnctionPool> connectPools=new HashMap<String,DBconnctionPool>(); 
    
    ArrayList<DsconfigBean> drivers=new ArrayList<DsconfigBean>();//bean类集合
    
    /**
     * 利用单例模式保证取得唯一的连接池管理类实例
     * @return
     */
    static public DBconnectionManager getInstance(){
        if(instance==null){
            instance=new DBconnectionManager();
        }
        return instance;
    }
    /**
     * 创建连接池
     * @param bean
     */
    public void createPool(DsconfigBean bean){
        
        DBconnctionPool pool=new DBconnctionPool();
        System.out.println(bean.getName());
        pool.setDriver(bean.getDriver());
        pool.setMaxConn(bean.getMaxCount());
        pool.setPassword(bean.getPassword());
        pool.setPoolName(bean.getName());
        pool.setUrl(bean.getUrl());
        pool.setUsername(bean.getUsername());
        connectPools.put(bean.getName(), pool);
    }
    /**
     * 加载驱动程序
     */
    public void loadDrivers(){
        ParseConfig oaConfig=new ParseConfig();
        drivers=oaConfig.ReadConfig();
        
    }
    /**
     * 初始化连接池参数
     * 1.调用类读取配置文件
     * 2.把读取到的有关driver的信息存储在集合drivers里
     */
    public void init(){
        loadDrivers();
        //遍历迭代创建相应的连接池
        DsconfigBean myBean=new DsconfigBean();
        
        for(int i=0;i<drivers.size();i++){
            myBean=drivers.get(i);
            createPool(myBean);
        }
        
    }
    /**
     * 根据连接池的名字得到一个连接
     * @param name
     * @return
     */
    public Connection getConnection(String name){
        DBconnctionPool pool=null;
        Connection conn=null;
        
        pool=(DBconnctionPool)connectPools.get(name);
        conn=pool.getConnection();
        return conn;
    }
    
}
