package com.dynamicproxy;

public class Worker implements Employee {
	public int salary =0;
	@Override
	public void addSalary(int amount) {
		// TODO �Զ����ɵķ������
		this.salary+=amount;
	}

	public String toString()
	{
		return "worker's salary:   "+this.salary;
	}
	
	
	
	
}
