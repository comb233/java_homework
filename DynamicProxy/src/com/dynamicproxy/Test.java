package com.dynamicproxy;
//import java.util.*;
import java.lang.reflect.Proxy;
//import java.util.List;
public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Manager manager=new Manager();
		Worker worker=new Worker();
		manager.addSalary(5000);
		worker.addSalary(1000);
		
				Employee employee1=(Employee)Proxy.newProxyInstance(Employee.class.getClassLoader(), 
						new Class[] {Employee.class}, new dynamic(worker));
				
	
				Employee employee2=(Employee)Proxy.newProxyInstance(Employee.class.getClassLoader(), 
						new Class[] {Employee.class}, new dynamic(manager));
			System.out.println(manager.toString());
	
		
	}

}
