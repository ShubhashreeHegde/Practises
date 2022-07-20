import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.Soundbank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	// Count the number of names starts with A in a list
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijith");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijith");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");

		// assigning arraylist to stream. Stream is a collection strings. In the stream
		// API there is a filter method
		// it will filter based on the filter
		// Lambda expression - It introduce the new arrow -> operator into java. Divides
		// the lambda expression in 2 parts.
		// left side specifies the parameter required it could also be empty if no
		// parameter is required
		// right side is the lambda body which specigies the actions of the lambda
		// expression
		// filter is the intermediate operator. To get the result we should perform
		// terminal operator(count) on filter
		// datatype of count should be long

		// here names will not be changed and it is untouched. From the name we are
		// streaming and working on that. So names arraylist will not chang
		Long c = names.stream().filter(s -> s.startsWith("A")).count(); // "s" variable scans all the strings parallely
																		// not sequentially
		// here if filter(s->s.startsWith("A") returns true then count method(terminal
		// operator) will execute. If false the count method will not execute
		// we can also create list of names like
		Long d = Stream.of("Abhijit", "don", "adam").filter(s -> s.startsWith("a")).count();
		// we can also write it as below because 2nd part is a body

		long d1 = Stream.of("Abhijit", "don", "adam").filter(s -> {
			s.startsWith("a");
			return true; // if we write false, count will not execute
		}).count();

		System.out.println(c);

		// printing all the names having more than 4 character length using streams
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		// printing all the names having more than 4 character length using streams with
		// limit
		names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));
	}

	@Test
	public void StreamMap() {
		
		//print the names owhich have last letter as a and convert to uppercase
		Stream.of("Abhijith", "Don", "Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));  
		//map will modify the stream filter results
		
		//print names which have first letter as "a" in uppercase and sort
		
		List<String> names=Arrays.asList("Abhijith", "Don", "Alekya","Adam","Rama")	;	//converting array to arraylist
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		//Merge 2 arraylist to one list
		List<String> names1=Arrays.asList("Abhijith", "Don", "Alekya","Adam","Rama")	;
		List<String> names11=Arrays.asList("man", "sd", "wd","erf","wf")	;
		Stream<String> newstream=  Stream.concat(names1.stream(), names11.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		//return true if the Adam is present
		//note : once the stream is modifies we cannot use that again. need to create new stream
		Stream<String> newstream1=  Stream.concat(names1.stream(), names11.stream());
		boolean flag=newstream1.anyMatch(s->s.equalsIgnoreCase("Adam")); //here will return True or false and that will store in flag variable
		Assert.assertTrue(flag); //if flag is true the asserttrue(true) is valid and test case will pass, if flag is false then its fail
	}
	
	
	@Test
	public void StreamCollect() {
		
		//collect will collect and return list (collect list, modify and create new list, and use that modified list)
		List<String> l1 = Stream.of("Abhijith", "Don", "Alekya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		//now print first element in the list
		System.out.println(l1.get(0));
		
		
		
		//Assignment : From the below list print the unique numbers and Sort it
		List<Integer> values=Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> l2 = values.stream().distinct().sorted().collect(Collectors.toList());
		//after sort give the 3rd index
		System.out.println(l2.get(2));  //because it will start from 0 so here we used 2 to fetch the 3rd
	}


}
