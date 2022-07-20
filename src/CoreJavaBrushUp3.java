
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//string is an object in java terminology, that represent sequence of characters
		//ways to define string is 'String literal' and new memory allocate operator

		//java will not create S5, If the text is same java  will not be create another object. 
		//This we call as object created using Sting literal
		String s1 = "Rahul Shetty Academy";
		String s5 = "Rahul Shetty Academy";
	

		//new, here 2 objects wil be created if there is a same text also. Explicitly we are telling to create object so 2 are creating
		//This we call as object created using Sting new keyword
		String s2 = new String("Welcome");
		String s3 = new String("Welcome");
		
		
		//breaking string
		String s11 = "Rahul Shetty Academy";
		 //String[] splittedString = s11.split(" ");    //splits 3 pieces as per whitspaces s1.split(" ");
		String[] splittedString = s11.split("Shetty");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());  //will remove the spaces in before and after
		for(int i=0; i <s11.length();i++)
		{

		System.out.println(s11.charAt(i));
		}
		
		
		//printing reverse string
		for(int i =s11.length();i>=0;i--)
		{

		System.out.println(s11.charAt(i));
		}

	}

}
