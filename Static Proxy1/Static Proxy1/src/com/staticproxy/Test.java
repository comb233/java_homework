package com.staticproxy;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		List<Employee>employees=Campany.getEmployees();
		for(Employee employee:employees)//����employees�б��Ԫ��
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
