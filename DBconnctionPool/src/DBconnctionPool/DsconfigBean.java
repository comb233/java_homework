package DBconnctionPool;

public class DsconfigBean {
	private String name;//���ݿ�����
    private String type;//���ӳ�����
    private String driver;//���ӳ�����
    private String url;//���ӳص�ַ
    private String username;//�û���
    private String password;//����
    private int maxCount;//���������
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    
}
