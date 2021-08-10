
public class MotorCycle extends  Vehicle{

	 private int refueling;
	 private int cleaning;
	 public MotorCycle(int carNumber, String serviceType) {

		super(carNumber, serviceType,"MCycle");
		this.refueling=1;
		this.cleaning=2;
	 }

	public int GetRefuelingTime() {
		return refueling;
	}
	public int CleaningTime() {
		return cleaning;
	}




	public void setCleaningTime(int cleaningTime) {
		this.cleaning = cleaningTime;
	}
	public void SetRefuelingTime(int refuelingTime) {
		this.refueling = refuelingTime;
	}

}
