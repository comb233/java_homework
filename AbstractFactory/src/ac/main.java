package ac;

public class main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       HaierFactory f1 = new HaierFactory();
       f1.produceTV().play();
       TCLFactory f2 = new TCLFactory();
       f2.produceAirC().changeTemp();
	}

}
