
public  abstract class Vehicle {
	 private int    VehicleId;
	 private String VehicleType;
	 private String Action;
	 private int    tempCount;
	 private int     StartTime;

	 public Vehicle(Vehicle v) {
		 if(v!=null) {
		 this.VehicleId =v.VehicleId;
			this.Action =v. Action;
			this.VehicleType=v.VehicleType;
			this.SetRefuelingTime(v.GetRefuelingTime());
			this.setCleaningTime(v.CleaningTime());
			this.StartTime=v.StartTime;
			this.tempCount=0;
		 }
	 }
	 public Vehicle(int carNumber, String serviceType ,String VehicleType ) {
			this.VehicleId = carNumber;
			this.Action = serviceType;
			this.VehicleType=VehicleType;
			/*if(this.VehicleType.equals("Trailer"))
			{
				this.RefuelingTime=5;
				this.CleaningTime=6;
			}else{
				if(this.VehicleType.equals("M.Cycle"))
				{
					this.RefuelingTime=1;
					this.CleaningTime=2;
				}
				else{
					if(this.VehicleType.equals("Private")){
						this.RefuelingTime=3;
						this.CleaningTime=4;
					}
					else{
						System.out.println("VehicleType is illegal :(");
					}
				}
			}*/

			this.tempCount=0;

		}

	/* Get Methods*/
	public int    getCarNumber()     { return VehicleId;  }
	public String getServiceType()   { return Action;     }
	public String getCarType()  {
		return VehicleType;
	}
	public int GetStartTime()  {
		return StartTime;
	}
	public int getTempCount()  { return tempCount;}



	/* Set Methods*/
	public void setServiceType(String serviceType) {  this.Action = serviceType;}
	public void setCarNumber(int carNumber)        {  this.VehicleId = carNumber;}
	public void setVehicleType(String carType) {
		this.VehicleType = carType;
	}
	public void setEntryTime(int entryTime) {
		this.StartTime = entryTime;
	}
	public void setTempCount(int TempCount) {this.tempCount=TempCount;}






	/*Abstract Methods*/
	abstract public int GetRefuelingTime();
	abstract public void SetRefuelingTime(int refuelingTime);
	abstract public int CleaningTime();
	abstract  public void setCleaningTime(int cleaningTime);


/*
	 public int getRefuelingTime(){return this.RefuelingTime;};
	 public void setRefuelingTime(int refTime){ this.RefuelingTime=refTime;};
	 public int getCleaningTime(){return this.CleaningTime;};
	 public void setCleaningTime(int cleanTime){this.RefuelingTime=cleanTime;};
*/

}
