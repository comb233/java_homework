package com.staticproxy;

public class Worker implements Employee{

	public int salary = 0;

	@Override
	public void addSalary(int amount) {
		// TODO �Զ����ɵķ������
	     this.salary += amount;
	}
    @Override
    public String toString() {
    	// TODO �Զ����ɵķ������
    	return "worker's salary:   "+this.salary;
    }
}
