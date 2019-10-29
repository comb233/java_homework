package DBconnctionPool;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 操作配置文件的类
 * @author abcd
 *
 */
public class ParseConfig {
	/**
     * 利用dom4j包读取配置文件内容返回集合beans
     * @return
     */
    public  ArrayList<DsconfigBean> ReadConfig(){
        ArrayList<DsconfigBean> beans=new ArrayList<DsconfigBean>();
        //得到解析器
        SAXReader saxReader=new SAXReader();
        //设置ErrorHander
        saxReader.setErrorHandler(new DefaultHandler(){
            public void error(SAXParseException ex){
                System.out.println(ex.getSystemId()+"文档的第"+ex.getLineNumber()+"行,第"+
                        ex.getColumnNumber()+"列"+"发生错误"+ex.getMessage());
            }
        });
        //创建树形结构开始解析
        try {
            Document document=saxReader.read("dsconfig.xml");
            Element root=document.getRootElement();//得到根节点
            //获得所有的pool下的节点
            List<Node> nodes=document.selectNodes("ds-config/pool");
            //System.out.println(nodes.size());
            //遍历节点
            for (Node node : nodes) {
                DsconfigBean dsconfigBean=new DsconfigBean();
                Node node1=node.selectSingleNode("driver");
                Node node2=node.selectSingleNode("username");
                Node node3=node.selectSingleNode("password");
                Node node4=node.selectSingleNode("url");
                Node node5=node.selectSingleNode("maxconn");
                Node node6=node.selectSingleNode("type");
                dsconfigBean.setDriver(node1.getStringValue());
                dsconfigBean.setUsername(node2.getStringValue());
                dsconfigBean.setPassword(node3.getStringValue());
                dsconfigBean.setUrl(node4.getStringValue());
                dsconfigBean.setMaxCount(Integer.valueOf(node5.getStringValue()));
                dsconfigBean.setName(node6.getStringValue());
                beans.add(dsconfigBean);
    
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return beans;
        
    }
}
