package serialize2;

public class SerializeTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Teacher t=new Teacher();
		SerializeTool.serialize(t,"teacher");
		SerializeTool.printFileInfo("teacher");
	}

}
