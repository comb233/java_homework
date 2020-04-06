package factory;

public class ClientClass {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
     Factory factor = new GFactory();
     GameCharacter ch = factor.createCharacter();
     ch.speak();
	}

}
