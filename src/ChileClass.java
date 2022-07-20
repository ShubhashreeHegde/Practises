
public class ChileClass extends ParentClass{

	public void engine()
	{
		System.out.println("engine");
	}
	
	public void colour()
	{
		System.out.println(color); 
	}
	
	
	public void audio()  //this is overriden from the parent class.
	{
		System.out.println("Child audio");
	}
	
	
	
	public static void main(String[] args) {

		ChileClass c=new ChileClass();
		c.colour();   //same class method --- accessible
		c.Break();  //parent class method --- accessible
		c.audio(); // while running it will give prefernce to our local system only (overriden method)
					//here both methods have same name, signatures, and parameters.

	}

}
