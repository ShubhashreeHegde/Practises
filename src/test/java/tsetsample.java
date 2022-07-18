import java.io.IOException;
import java.util.ArrayList;

public class tsetsample {

	public static void main(String[] args) throws IOException {


		dataDriven d=new dataDriven(); 					//ctreating object for dataDriven class to access the method in that
		ArrayList<String> data = d.getData("Add Profile");  //what we need to access that should be given inside. because d.getData("Add Profile") will return teh arralist
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
