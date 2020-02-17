package factory;

public class GFactory extends Factory{

	public GameCharacter createCharacter() {
		
		return new GaiLun();
	}
}
