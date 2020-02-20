package ac;

public class HaierFactory extends EFactory{

	public TV produceTV() {
		HaierTV tv = new HaierTV();
		return tv;
	}
	public AirC produceAirC() {
		AirC air = new AirC();
		return air;
	}
}
