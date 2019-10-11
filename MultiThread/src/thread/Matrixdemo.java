//10个线程
package thread;

public class Matrixdemo implements Runnable{

	private static int num =10;
	private static int row=100,column=100; //行和列
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		long begin=System.nanoTime();
		//System.out.println("开始了吗");
		
		for(;row<=1000&column<=1000;row+=100,column+=100) {
		
		for(int j=1;j<=10;j++)
		{
			final int s=j;
			Matrixdemo myRunnable = new Matrixdemo();
	        new Thread(myRunnable).start();
	  }
		long end=System.nanoTime();
		System.out.print("10个线程计算纬度是"+row+"的矩阵花费总时间是：");
		System.out.println((end-begin)/1000000.00+"毫秒");
		}
   }

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
		while (true)  {
			synchronized (Matrixdemo.class) {
				 if (num == 0) {
                     break;
                 }
				 else {
						//long begin2=new Date().getTime();
						double[][] m1 = new double[row][column];
						//设置第一个矩阵
						for(int i = 0 ; i < row ; i++)
							for(int j = 0 ; j < column ; j++)
								m1[i][j] =(int)(Math.random()*100);
						GenericMatrix matrix1 = new GenericMatrix(m1);
						//设置第二个矩阵
						double[][] m2 = new double[row][column];
						for(int i = 0 ; i < row ; i++)
							for(int j = 0 ; j < column ; j++)
								m2[i][j] =(int)(Math.random()*100);
						GenericMatrix matrix2 = new GenericMatrix(m2);
						GenericMatrix matrix3 = matrix1.multiply(matrix2);
//						long end2=new Date().getTime();
//						System.out.print("两个"+row+"*"+column+"的矩阵相乘所花费的时间是：");
//						System.out.println(end2-begin2);
						//row+=100;column+=100;
						num--;
				 }
		    }
	    }
    }
}
