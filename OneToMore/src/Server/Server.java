package Server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	public static HashMap<String, ObjectOutputStream> users= new HashMap<String,ObjectOutputStream>();
	public static void main(String[] args) throws Exception{//一对多的聊天
		ServerSocket server = new ServerSocket(8888);
		while(true){
			System.out.println("正在等待。。。");
			Socket socket = server.accept();
			SocketHandler handler = new SocketHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}
