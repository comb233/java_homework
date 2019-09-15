package com.staticproxy;

public class Worker implements Employee{

	public int salary = 0;

	@Override
	public void addSalary(int amount) {
		// TODO 自动生成的方法存根
	     this.salary += amount;
	}
    @Override
    public String toString() {
    	// TODO 自动生成的方法存根
    	return "worker's salary:   "+this.salary;
    }
}
