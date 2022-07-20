
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo d = new MethodsDemo();
		String name = d.getData();   //returned o/p from method storing in name variable
		System.out.println(name);
		MethodsDemo2 d1 = new MethodsDemo2();
		d1.getUserData();
		getData2();  // accessible without object because that is declared as static.


		}

		public String getData()
		{
		System.out.println ("hello world");
		return "rahul shetty";
		}

		public static String getData2()  //i fwe mark as a static then methond belongs to class not a object. Class level permission will get that method
		{
		System.out.println ("hello world");
		return "rahul shetty";
		}
		
	

}
