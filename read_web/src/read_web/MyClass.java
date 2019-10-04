package read_web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 通过URL读取页面内容
 * */

public class MyClass {

	  public static void main(String[] args){

        System.out.println("hello world !!!");

        try {
            //创建一个URL实例
            URL url = new URL("http://www.baidu.com");

            try {
                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is,"utf-8");

                //为字符输入流添加缓冲
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据

                while (data!=null){//循环读取数据
                    System.out.println(data);//输出数据
                    data = br.readLine();
                }
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}//这样就能获取百度页面的html代码了
