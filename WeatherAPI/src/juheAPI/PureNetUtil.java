package juheAPI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/**
 * ������ʹ�����
 * @author silk
 *
 */
public class PureNetUtil {
    /**
     * get����ֱ�ӵ���post����
     * @param url �����ַ
     * @return ������������
     */
    public static String get(String url){
        return post(url,null);
    }
    /**
     * �趨post������ȡ������Դ,�������Ϊnull,ʵ�����趨Ϊget����
     * @param url �����ַ
     * @param param ���������ֵ��
     * @return ���ض�ȡ����
     */
   public static <K, V> String post(String  url,Map<K,V>   param){
        HttpURLConnection conn=null;
        try {
            URL u=new URL(url);
            conn=(HttpURLConnection) u.openConnection();
            StringBuffer sb=null;
            if(param!=null){//������������Ϊ��
                sb=new StringBuffer();
                /*A URL connection can be used for input and/or output.  Set the DoOutput
                 * flag to true if you intend to use the URL connection for output,
                 * false if not.  The default is false.*/
                //Ĭ��Ϊfalse,post������Ҫд�����,�趨true
                conn.setDoOutput(true);
                //�趨post����,Ĭ��get
                conn.setRequestMethod("POST");
                //��������
                OutputStream out=conn.getOutputStream();
                //���������װ�ɸ߼������
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
                //��������װ�ɼ�ֵ�Ե���ʽ
                for(Map.Entry s:param.entrySet()){
                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
                }
                //������ͨ�������д��
                writer.write(sb.deleteCharAt(sb.toString().length()-1).toString());
                writer.close();//һ��Ҫ�ر�,��Ȼ���ܳ��ֲ�����ȫ�Ĵ���
                sb=null;
            }
            conn.connect();//��������
            sb=new StringBuffer();
            //��ȡ����״̬��
            int recode=conn.getResponseCode();
            BufferedReader reader=null;
            if(recode==200){
                //Returns an input stream that reads from this open connection
                //�������л�ȡ������
                InputStream in=conn.getInputStream();
                //�����������з�װ
                reader=new BufferedReader(new InputStreamReader(in));
                String str=null;
                sb=new StringBuffer();
                //���������ж�ȡ����
                while((str=reader.readLine())!=null){
                    sb.append(str).append(System.getProperty("line.separator"));
                }
                //�ر�������
                reader.close();
                if (sb.toString().length() == 0) {
                    return null;
                }
                return sb.toString().substring(0,
                        sb.toString().length() - System.getProperty("line.separator").length());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if(conn!=null)//�ر�����
                conn.disconnect();
        }
        return null;
    }
   
}