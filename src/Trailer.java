
public class Trailer extends  Vehicle {
	 private int refuelingTime;
	 private int cleaningTime;
	public Trailer(int carNumber, String serviceType) {
		super(carNumber, serviceType,"Trailer");
		this.refuelingTime=5;
		this.cleaningTime=6;
}
	public int GetRefuelingTime() {
		return refuelingTime;
	}
	public void SetRefuelingTime(int refuelingTime) {
		this.refuelingTime = refuelingTime;
	}
	public int CleaningTime() {
		return cleaningTime;
	}
	public void setCleaningTime(int cleaningTime) {
		this.cleaningTime = cleaningTime;
	}
	
}
