
public class ChildClass extends ParentClass{
		
	public void engine()
	{
		System.out.println("engine");
	}
	
	public void colour()
	{
		System.out.println(color);  //accessed directly from parent class because of inheritance
	}
	
	
	
	
	
	
	public static void main(String[] args) {

		ChildClass c=new ChildClass();
		c.colour();   //same class method --- accessible
		c.Break();  //parent class method --- accessible
		

	}

}
