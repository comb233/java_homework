package factory;

public class ClientClass {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
     Factory factor = new GFactory();
     GameCharacter ch = factor.createCharacter();
     ch.speak();
	}

}
