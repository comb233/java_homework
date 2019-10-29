package DBconnctionPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ���ݿ����ӳع�����
 * @author abcd
 *
 */
public class DBconnectionManager {
	public int clients;//�ͻ���������
    static private DBconnectionManager instance;//Ψһ�����ӳع�����ʵ��
    HashMap<String,DBconnctionPool> connectPools=new HashMap<String,DBconnctionPool>(); 
    
    ArrayList<DsconfigBean> drivers=new ArrayList<DsconfigBean>();//bean�༯��
    
    /**
     * ���õ���ģʽ��֤ȡ��Ψһ�����ӳع�����ʵ��
     * @return
     */
    static public DBconnectionManager getInstance(){
        if(instance==null){
            instance=new DBconnectionManager();
        }
        return instance;
    }
    /**
     * �������ӳ�
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
     * ������������
     */
    public void loadDrivers(){
        ParseConfig oaConfig=new ParseConfig();
        drivers=oaConfig.ReadConfig();
        
    }
    /**
     * ��ʼ�����ӳز���
     * 1.�������ȡ�����ļ�
     * 2.�Ѷ�ȡ�����й�driver����Ϣ�洢�ڼ���drivers��
     */
    public void init(){
        loadDrivers();
        //��������������Ӧ�����ӳ�
        DsconfigBean myBean=new DsconfigBean();
        
        for(int i=0;i<drivers.size();i++){
            myBean=drivers.get(i);
            createPool(myBean);
        }
        
    }
    /**
     * �������ӳص����ֵõ�һ������
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
