package Client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Command;
import Model.Login;
import Model.Logout;
import Model.Message;
import Model.Register;
import Model.Result;

public class Client {
	private static Command c;
	private static Result rs;
	public static void main(String[] args) throws Exception{
	
		Socket socket = new Socket("127.0.0.1",8888);	
		OutputStream os=socket.getOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(os);
		
		InputStream reader = socket.getInputStream();
		
		ObjectInputStream ois=new ObjectInputStream(reader);
		Scanner input= new Scanner(System.in);
		boolean f=true;//循环判断
		String name=null;//发送方姓名
		String toName=null;//接收方姓名
		int temp=0;//用于定位是否是已经在聊天了
		int i=0;
		int logout=0; //判断是否退出
		
		System.out.println("请选择:1.注册  2.登陆  3.发消息  4.退出:");
		
		while(f){

				i=input.nextInt();
				 if(i==1){//注册
				 System.out.print("我是:");
				 name=input.next();
				 Register register=new Register();
				register.setName(name);
				register.setSendDate(new Date());
				Result result = new Result(register, "1");
				 oos.writeObject(result);
				 rs=(Result)ois.readObject();
				 System.out.println("服务器响应: command="+rs.getCommand()+ "state="+rs.getState());
			 }else if(i==2){//登录
				 System.out.print("我是:");
				// String name="xu";
				 name=input.next();
				Login login=new Login();
				login.setName(name);
				// c.setSendDate(new Date());
				Result result = new Result(login, "2");
				 oos.writeObject(result);
				 rs=(Result)ois.readObject();
				 System.out.println("服务器响应: command="+rs.getCommand()+ "state="+rs.getState());
			 }else if(i==3){//聊天中...
					System.out.print("接受方姓名:");
					toName=input.next();
					 System.out.print("我("+name+")说:");	
				 	//name=input.next();
					
					String message=input.next();;
					Message message2=new Message();
					message2.setFrom(name);
					message2.setTo(toName);
					message2.setMessage(message);
					
					 temp=1;
				
				 if(message.equals("logout")){//如果输入logou就代表退出聊天服务器
					 logout=1;
				 }else{
					// c.setSendDate(new Date());
						Result result = new Result(message2, "3");
						 oos.writeObject(result);
					//读到消息
					Message m=(Message)ois.readObject();
					String str="我对"+toName+ "说："+m.getMessage();
					System.out.println(str);
					FileInformation(str,"我");
					 }			 			 
			 }
			 if(i==4||logout==1){//退出
				Logout logout2=new Logout();
				logout2.setName(name);
				//c.setSendDate(new Date());
				Result result = new Result(logout2, "4");
				 oos.writeObject(result);
				 rs=(Result)ois.readObject();
				 System.out.println("服务器响应: command="+rs.getCommand()+ "state="+rs.getState());
				 f=false;
			 }
		 }	
		//System.out.println("欢迎再次光临！bye");
		ois.close(); 
		oos.close(); 
		socket.close(); 
		
	}
	 public static void FileInformation(String texts,String name ){//显示收到的文本
			JFrame showInfo=new JFrame();
			JPanel jp=new JPanel();
			JTextArea text=new JTextArea(20,20);//文本区
			text.append(texts+"\n");//输入
			jp.add(text);
			showInfo.add(jp);
			
			showInfo.setTitle(name+"回答！");
			showInfo.setVisible(true);
			showInfo.setSize(300,200);
			showInfo.setLocation(500, 500);
			showInfo.setDefaultCloseOperation(1);
	}
}
