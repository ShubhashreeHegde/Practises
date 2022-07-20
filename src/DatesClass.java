import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesClass {

	public static void main(String[] args) {

		//current date...current time
		//Date class and collections will come from util package
		Date d=new Date();
		System.out.println(d.toString());
		
		//if we want to print in the format mm/dd/yyyy HH:MM:SS
		//SimpleDateFormat is the class created to print as per our requirement. Which format we need we should pass inside paranthesis while creating object
		SimpleDateFormat sd=new SimpleDateFormat("MM/dd/yyyy");  //here mm if we put small letter it wont work
		SimpleDateFormat sd1=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  //should be small letter of time format for 12hrs, capital letter for 24hrs
		
		//now date is in d object and format is in sd object. So we need to combine that
		System.out.println(sd.format(d));
		System.out.println(sd1.format(d));

	}

}
