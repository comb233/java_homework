package com.matrix;

public class GenericMatrix {
	int row , column;
	double[][] matrix;
	//构造函数
	GenericMatrix(double[][] matrix){
		this.row = matrix.length;
		this.column = matrix[0].length;
		this.matrix = new double[this.row][this.column];
		for(int i = 0 ; i < this.row ; i++)
			for(int j = 0 ; j < this.column ; j++)
				this.matrix[i][j] = matrix[i][j];
	}
	//矩阵加法
	GenericMatrix add(GenericMatrix mat2){
		double[][] add_result = new double[this.row][this.column];
		for(int i = 0 ; i < this.row ; i++)
			for(int j = 0 ; j < this.column ; j++)
				add_result[i][j] = this.matrix[i][j]+mat2.matrix[i][j];
		return new GenericMatrix(add_result);
	}
	
	//矩阵乘法
	GenericMatrix multiply(GenericMatrix mat2){
		double[][] multiply_result = new double[this.row][mat2.column];
		for(int i = 0 ; i < this.row ; i++ )
			for(int j = 0 ; j < mat2.column ; j++)
				for(int k = 0 ; k < mat2.row ; k++ ){
					multiply_result[i][j] += this.matrix[i][k]*mat2.matrix[k][j];  
				}
		return new GenericMatrix(multiply_result);
	}
	//打印函数
	void printResult(){
		for(int i = 0 ; i < this.row ; i++){
			for(int j = 0 ; j < this.column ; j++){
				System.out.print(this.matrix[i][j] + " ");	
			}
			System.out.println();
		}
	}

}
