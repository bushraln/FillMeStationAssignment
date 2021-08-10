
public class Private extends  Vehicle {
	 private int refuelingTime;
	 private int cleaningTime;
	public Private(int carNumber, String serviceType) {
		super(carNumber, serviceType,"Private");
		this.refuelingTime=3;
	this.cleaningTime=4;
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
