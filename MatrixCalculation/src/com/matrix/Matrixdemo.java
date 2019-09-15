package com.matrix;

import java.util.Scanner;

public class Matrixdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row , column;//行和列
		String select , judge;//运输类型，是否继续运算
		
		//第一个矩阵
		System.out.println("输入第一个矩阵的行数和列数：");
		row = sc.nextInt();
		column = sc.nextInt();
		double[][] m = new double[row][column];
		System.out.println("设置第一个矩阵：");
		for(int i = 0 ; i < row ; i++)
			for(int j = 0 ; j < column ; j++)
				m[i][j] = sc.nextDouble();
		GenericMatrix matrix1 = new GenericMatrix(m);
		//第二个矩阵
		System.out.println("输入第二个矩阵的行数和列数：");
		row = sc.nextInt();
		column = sc.nextInt();
		m = new double[row][column];
		System.out.println("设置第二个矩阵：");
		for(int i = 0 ; i < row ; i++)
			for(int j = 0 ; j < column ; j++)
				m[i][j] = sc.nextDouble();
		GenericMatrix matrix2 = new GenericMatrix(m);
		//选择要进行的运算
		while(true){
			System.out.println("选择要进行的运算(+/*)：");
			select = sc.next();
			if(select.equals("+")){
				if(matrix1.row != matrix2.row || matrix1.column != matrix2.column){
					System.out.println("错误!不符合矩阵运算法则!");
				}
				else{
					GenericMatrix matrix3 = matrix1.add(matrix2);
					System.out.println("矩阵相加 =");
					matrix3.printResult();
				}
			}
			if(select.equals("*")){
				if(matrix1.column != matrix2.row){
					System.out.println("错误!不符合矩阵运算法则!");
				}
				else
				{
					GenericMatrix matrix3 = matrix1.multiply(matrix2);
					System.out.println("矩阵相乘 =");
					matrix3.printResult();
				}
			}
			if(!(select.equals("*")||select.equals("+"))){
				
				System.out.print("输入错误，再接再厉");
				continue;
			}
			
			System.out.println("选择其它运算?(Y/N)");
			judge = sc.next();
			if(judge.equals("Y")|judge.equals("y"))
				continue;
			else
				break;
		}
		sc.close();
 

	}
}
