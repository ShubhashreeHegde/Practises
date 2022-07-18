
public class childEmirites extends ParentAircraft {

	public static void main(String[] args) {

		childEmirites c=new childEmirites();
		c.bodycolor();
		c.engine();
		c.safteyguidlines();
		
		//If any class create as an abstract then we cannot create object for that class
		//ParentAircraft c=new childEmirites();
	}

	@Override
	public void bodycolor() {
		

		System.out.println("bodycolor");
	}

}
