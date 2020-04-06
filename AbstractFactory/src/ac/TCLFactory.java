package ac;

public class TCLFactory extends EFactory{
	
	public TV produceTV() {
		TCLTV tv = new TCLTV();
		return tv;
	}
	public AirC produceAirC() {
		TCLAirC air = new TCLAirC();
		return air;
	}
}
