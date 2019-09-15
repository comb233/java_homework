package com.staticproxy;


import java.util.*; 
public class Campany {
	public static List<Employee>getEmployees(){
		List<Employee>employees=new ArrayList<Employee>();
		Random random=new Random();
		for(int i =0;i<5;i++)
		{
			if(random.nextInt(5)>3)//生成0到5之间的整数
			{
				employees.add(new Manager());
				}
			else
				employees.add(new Worker());
		}
		return employees;
	}


}
