
public class ChildLevel extends ChildClassDemo{

	public void getdata(int a)
	{
		System.out.println(a);
	}
	
	public void getdata(String a) //or can use (int a, int b)
	{
		System.out.println(a);
	}
	
	public void getdata(int a, int b) 
	{
		System.out.println(b);
	}
	
	
	public static void main(String[] args) {
		
		ChildLevel c=new ChildLevel();
		c.getdata(1);
		c.getdata("hello");
		c.getdata(1, 100);	
	}

}
