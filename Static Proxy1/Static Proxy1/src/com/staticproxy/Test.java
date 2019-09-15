package com.staticproxy;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<Employee>employees=Campany.getEmployees();
		for(Employee employee:employees)//遍历employees列表的元素
		{
			if(employee instanceof Manager)
			{
				employee.addSalary(5000);
			}
			else
				employee.addSalary(1000);
			System.out.println(employee.toString());
		}
		
	}

}
