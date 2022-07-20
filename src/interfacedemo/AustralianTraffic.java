package interfacedemo;

public class AustralianTraffic implements CentralTraffic,ContinentTraffic {

	public static void main(String[] args) {

		//to execute the methods we have to create a class object. Create for centraltraffic class itself because we are just accessing that methods
		//because this is interface implementation
		CentralTraffic a = new AustralianTraffic();
		a.greenGo();
		a.redStop();
		a.flashyellow();
		
		//above object will not work to access method sof this class
		AustralianTraffic at=new AustralianTraffic();
		at.walkonsymbol();
		
		//once class can implement more than one interface
		ContinentTraffic ac = new AustralianTraffic();
		ac.TrainSymbol();
	}

	@Override
	public void greenGo() {
		System.out.println("Green");
		
	}

	@Override
	public void redStop() {
		System.out.println("Red");
		
	}

	@Override
	public void flashyellow() {
		System.out.println("flashyellow");
		
	}
	
	//we can create methods which is specific to australian
	public void walkonsymbol()
	{
		System.out.println("walkonsymbol");
	}

	@Override
	public void TrainSymbol() {
		System.out.println("TrainSymbol");
		
	}
	

}
