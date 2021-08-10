
import java.util.LinkedList;
import java.util.List;

class RefuelStation extends Vehicle {
	private int Refueling;
	private boolean status;

	public RefuelStation() {
		super(0 ,  null , null);
		Refueling = 0;
		this.status = false;
	}

	public RefuelStation(int CarId, String Operation ,String Type, int Refueling, boolean status) {
		super( CarId,  Operation , Type);
		Refueling = Refueling;
		this.status = status;
	}
	public int GetRefuelingTime() {
		return Refueling;
	}
	public void SetRefuelingTime(int refuelingTime) {
		Refueling = refuelingTime;
	}
	public boolean GetStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int  CleaningTime() {
		return 0;
	}
	@Override
	public void setCleaningTime(int cleaningTime) {

	}
}


class CleanStation extends  Vehicle  {
	private int CleaningTime;
	private boolean status;
	public CleanStation() {
		super(0 ,  null , null);
		CleaningTime = 0;
		this.status = false;
	}
	public CleanStation(int carNumber, String serviceType , String carType, int cleaningTime, boolean statuse) {
		super( carNumber,  serviceType , carType);
		CleaningTime = cleaningTime;
		this.status = statuse;
	}
	public int CleaningTime() {
		return CleaningTime;
	}
	public void setCleaningTime(int cleaningTime) {
		CleaningTime = cleaningTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public int GetRefuelingTime() {
		return 0;
	}
	@Override
	public void SetRefuelingTime(int refuelingTime) {

	}

}


public class Station {
	static int Index=0;
	static RefuelStation	currRefuel  =  new RefuelStation();
	static CleanStation     CurrClean=  new CleanStation();
	static List<Vehicle>       Vehicles    =  new LinkedList<Vehicle>();
	static LinkedList<Vehicle> nextClean   =  new LinkedList<Vehicle>();
	static LinkedList<Vehicle> nextRef     =  new LinkedList<Vehicle>();
	static int time=0;
	public static void ActiveTime(int entryTime,int processTime  ){
		time=entryTime+processTime;
	   }


	public static void FillInformationVehicle(List<Vehicle> newVehicle) {

		newVehicle.clear();

		newVehicle.add(new MotorCycle(Index++,"RC"));
		newVehicle.add(new Trailer(Index++,"R"));
		newVehicle.add(new MotorCycle(Index++,"RC"));
		newVehicle.add(new Private(Index++,"C"));
		newVehicle.add(new Private(Index++,"C"));
		newVehicle.add(new Private(Index++,"R"));
		newVehicle.add(new Private(Index++,"R"));
		newVehicle.add(new MotorCycle(Index++,	"R"));
		newVehicle.add(new MotorCycle(Index++,"R"));
		newVehicle.add(new Private(Index++,"RC"));
		newVehicle.add(new Trailer(Index++,"C"));
		newVehicle.add(new MotorCycle(Index++,"R"));
		newVehicle.add(new Private(Index++,"R"));
		newVehicle.add(new Trailer(Index++,"RC"));
		newVehicle.add(new Private(Index++,"R"));

		/*
		newVehicle.add(new Vehicle(Index++,"RC","M.Cycle"));
		newVehicle.add(new Vehicle(Index++,"R","Trailer"));
		newVehicle.add(new Vehicle(Index++,"RC","M.Cycle"));
		newVehicle.add(new Vehicle(Index++,"C","Private"));
		newVehicle.add(new Vehicle(Index++,"C","Private"));
		newVehicle.add(new Vehicle(Index++,"R","Private"));
		newVehicle.add(new Vehicle(Index++,"R","Private"));
		newVehicle.add(new Vehicle(Index++,	"R","M.Cycle"));
		newVehicle.add(new Vehicle(Index++,"R","M.Cycle"));
		newVehicle.add(new Vehicle(Index++,"RC","Private"));
		newVehicle.add(new Vehicle(Index++,"C","Trailer"));
		newVehicle.add(new Vehicle(Index++,"R","M.Cycle"));
		newVehicle.add(new Vehicle(Index++,"R","Private"));
		newVehicle.add(new Vehicle(Index++,"RC","Trailer"));
		newVehicle.add(new Vehicle(Index++,"R","Private"));*/

		StartMainCondtions(newVehicle);


	}


	public static void StartRefueling(Vehicle vehicle) {

		currRefuel.setStatus(true);
		currRefuel.SetRefuelingTime(vehicle.GetRefuelingTime());
		currRefuel.setCarNumber(vehicle.getCarNumber());
		currRefuel.setServiceType(vehicle.getServiceType());
		currRefuel.setVehicleType(vehicle.getCarType());
		currRefuel.setTempCount(vehicle.getTempCount()+1);
		currRefuel.setEntryTime(time);
		Vehicles.get(currRefuel.getCarNumber()).setTempCount(currRefuel.getTempCount());
		System.out.println(" Vehicle "+vehicle.getCarNumber()+ " with type "+vehicle.getCarType()+ " starts refueling in time "+ time+".");



	}

	public static void StartCleaning(Vehicle vehicle) {
		CurrClean.setStatus(true);
		CurrClean.setCleaningTime(vehicle.CleaningTime());
		CurrClean.setCarNumber(vehicle.getCarNumber());
		CurrClean.setServiceType(vehicle.getServiceType());
		CurrClean.setVehicleType(vehicle.getCarType());
		CurrClean.setTempCount(vehicle.getTempCount()+1);
		CurrClean.setEntryTime(time);
		 Vehicles.get(CurrClean.getCarNumber()).setTempCount(CurrClean.getTempCount());

		 System.out.println(" Vehicle "+vehicle.getCarNumber()+ " with type "+vehicle.getCarType()+" starts cleaning in time "+ time+".");
	}
	public static int  RestTime(int processTime ,int entryTime){
		return processTime-(time -entryTime);
	}
	public static void RefuelingToCleaning() {
		if(currRefuel.getServiceType().equals("RC")&&currRefuel.getTempCount()<2)
			if(CurrClean.isStatus()==false)
				StartCleaning(Vehicles.get(currRefuel.getCarNumber()));
			else
				nextClean.addFirst(Vehicles.get(currRefuel.getCarNumber()));
	}
	public static void CleaningToRefueling() {
		if(CurrClean.getServiceType().equals("RC")&&CurrClean.getTempCount()<2)
			if(currRefuel.GetStatus()==false)
				StartRefueling(Vehicles.get(CurrClean.getCarNumber()));
			else
				nextRef.addFirst(Vehicles.get(CurrClean.getCarNumber()));
	}
	public static void TurnOfNextRefuel() {

		currRefuel.setStatus(false);
		if(!nextRef.isEmpty()) {
			StartRefueling(nextRef.getFirst());
			nextRef.removeFirst();
		}
	}
	public static void TurnOfNextClean() {

		CurrClean.setStatus(false);
		if(!nextClean.isEmpty()) {
			StartCleaning(nextClean.getFirst()) ;
			nextClean.removeFirst();
		}
	}

	public static void checkWhichVehicleIsFinish(){
		
				if(RestTime(CurrClean.CleaningTime(),CurrClean.GetStartTime())>RestTime(currRefuel.GetRefuelingTime(),currRefuel.GetStartTime()))
					{
						ActiveTime(currRefuel.GetStartTime(),currRefuel.GetRefuelingTime());
						RefuelingToCleaning();
						TurnOfNextRefuel();
					}
				else 
					if(RestTime(CurrClean.CleaningTime(),CurrClean.GetStartTime())<RestTime(currRefuel.GetRefuelingTime(),currRefuel.GetStartTime()))
						{ActiveTime(CurrClean.GetStartTime(),CurrClean.CleaningTime());
							CleaningToRefueling();
							TurnOfNextClean();
						}
				else 
					if(RestTime(CurrClean.CleaningTime(),CurrClean.GetStartTime())==RestTime(currRefuel.GetRefuelingTime(),currRefuel.GetStartTime())) {
						ActiveTime(CurrClean.GetStartTime(),CurrClean.CleaningTime());
						CleaningToRefueling();
						TurnOfNextRefuel();
						TurnOfNextClean();

					
						
					}
				
		
}
	public static void Wait() {
		while(nextClean.isEmpty()!=true||nextRef.isEmpty()!=true) {
			if(currRefuel.GetStatus()==true && CurrClean.isStatus()==true)
				checkWhichVehicleIsFinish();							
			else if(CurrClean.isStatus()==true)
			{
				ActiveTime(CurrClean.GetStartTime(),CurrClean.CleaningTime());
				CleaningToRefueling();
				TurnOfNextClean();
			}
			
			else if(currRefuel.GetStatus()==true  ) {
				ActiveTime(currRefuel.GetStartTime(),currRefuel.GetRefuelingTime());
				RefuelingToCleaning();
				TurnOfNextRefuel();}
		}

	}
	public static void StartMainCondtions(List<Vehicle> allVehicles) {
		Vehicles.clear();
		Vehicles.addAll(allVehicles);
		int i =0;
		while((Vehicles.size())>i) {

			if (currRefuel.GetStatus() == true && CurrClean.isStatus() == true)
				checkWhichVehicleIsFinish();
			if (Vehicles.get(i).getServiceType().equals("C")) {
				if (CurrClean.isStatus() == false)
					StartCleaning(Vehicles.get(i));
				else
					nextClean.add(Vehicles.get(i));
			} else if (Vehicles.get(i).getServiceType().equals("R")) {
				if (currRefuel.GetStatus() == false)
					StartRefueling(Vehicles.get(i));
				else
					nextRef.add(Vehicles.get(i));
			} else if (Vehicles.get(i).getServiceType().equals("RC")) {
				if (currRefuel.GetStatus() == false)
					StartRefueling(Vehicles.get(i));
				else if (CurrClean.isStatus() == false)
					StartCleaning(Vehicles.get(i));
				else {
					if (nextRef.size() <= nextClean.size())
						nextRef.add(Vehicles.get(i));
					else
						nextClean.add(Vehicles.get(i));
				}
			}


			if (Vehicles.size() - 1 == i)
				Wait();
		//}
			i++;
		}
			
			

	}


	public static void main(String[] args) {
		 List<Vehicle> allVehicleList=new LinkedList<Vehicle>();
		 FillInformationVehicle(allVehicleList);

	}
	 

}
