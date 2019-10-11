package serialize2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTool {
	public static void serialize(Object obj,String fileName)throws Exception{
		File file=new File(fileName);    //新建一个本地文件，用于存储，序列化的对象字节流
		FileOutputStream output=new FileOutputStream(file);  //文件输出流
		ObjectOutputStream oos=new ObjectOutputStream(output);  //对象输出流
		oos.writeObject(obj);  //将对象写入对象输出流中
		oos.flush();     //提交对象输入流
		oos.close();
		output.close();
	}
	
public static Object deSerialize(String fileName) throws Exception{
		File file=new File(fileName);
		FileInputStream input=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(input);
		Object obj=ois.readObject();   //从对象输入流中 读取对象
		ois.close();
		input.close();
		return obj;
	}

public static void printFileInfo(String fileName) {
		File file=new File(fileName);   //获取本地文件
		System.out.println("-------------------------------");
		System.out.println("<FileName>:"+fileName);  //打印文件名
		System.out.println("<FileName>:"+file.length()+"bytes");  //打印文件大小
		System.out.println("-------------------------------");
	}
}
