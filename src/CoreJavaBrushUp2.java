import java.util.ArrayList;  // each pacckage has multiple of methids

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = { 1, 2, 4, 5, 6,7,8,9,10,122};
		//displaying o/p : no which is multipled by 2
		for(int i=0; i<arr2.length;i++)
		{
			if(arr2[i] % 2==0)
			{
				System.out.println(arr2[i]);
				break;  //if our requirement is achieved in mid and dont want to continue loop. It will exit the for loop after going inside the if condition
			}
			else
			{
				System.out.println(arr2[i]+"is not multiple of 2");
			}
		}
		
		// if the product number changed in future so we get pbm, so we are using arralist
		//arralist is the class in java. if we need to access any methods of class so need to create object
		// new will allocate memory for object
		ArrayList<String> a = new ArrayList<String>();
		a.add("test");  //this will store in 0 index
		a.add("selenium");    //this will store in 1 index
		a.add("code");    //this will store in 2 index
		a.remove(2);
		a.get(1);
		System.out.println(a.get(1));
		
		
		// array we call 4th index like a[4], but in array list a.get[4]
		
	}

}
