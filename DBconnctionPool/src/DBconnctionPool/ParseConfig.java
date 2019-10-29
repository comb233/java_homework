package DBconnctionPool;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.io.SAXReader;
import org.w3c.dom.Node;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ���������ļ�����
 * @author abcd
 *
 */
public class ParseConfig {
	/**
     * ����dom4j����ȡ�����ļ����ݷ��ؼ���beans
     * @return
     */
    public  ArrayList<DsconfigBean> ReadConfig(){
        ArrayList<DsconfigBean> beans=new ArrayList<DsconfigBean>();
        //�õ�������
        SAXReader saxReader=new SAXReader();
        //����ErrorHander
        saxReader.setErrorHandler(new DefaultHandler(){
            public void error(SAXParseException ex){
                System.out.println(ex.getSystemId()+"�ĵ��ĵ�"+ex.getLineNumber()+"��,��"+
                        ex.getColumnNumber()+"��"+"��������"+ex.getMessage());
            }
        });
        //�������νṹ��ʼ����
        try {
            Document document=saxReader.read("dsconfig.xml");
            Element root=document.getRootElement();//�õ����ڵ�
            //������е�pool�µĽڵ�
            List<Node> nodes=document.selectNodes("ds-config/pool");
            //System.out.println(nodes.size());
            //�����ڵ�
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
