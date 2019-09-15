package com.dynamicproxy;

public class Manager  implements Employee {
	public int salary =0;
	public void addSalary(int amount)
	{
		this.salary+=amount;
	}

	public String toString()
	{
		return "Manager's salary:   "+this.salary;
	}
}
