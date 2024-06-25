package CollectionOperationOnObject;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import CollectionOperationOnObject.Person;

public class Example {
	static Integer ans;
	public static void main(String[] args) {
		String s = "sanja";
		List<Person> listOfPeople = new ArrayList<Person>();
		
		listOfPeople.add(new Person(5, "Sanjay" ,500.0));
		listOfPeople.add(new Person(3, "Pakhi" ,100.0));
		listOfPeople.add(new Person(1, "Bhavana" ,400.0));
		listOfPeople.add(new Person(1, "Meera" ,200.0));
		listOfPeople.add(new Person(4, "Bijender" ,300.0));
		
		Map<Integer, Long> result; 
		result = listOfPeople.stream().collect(Collectors.groupingBy(Person :: getId,Collectors.counting()));	
		//System.out.print(result.toString());
		
		result.forEach((a,b)->{
			//System.out.print(a+"   "+b.toString()+"\n");
		});
		
		int a = 4;
		int c = a<<1; // Left Shift
		int b = a>>1; // Right Shift
		
		 System.out.println(c+" hello "+b);
		 
		 TreeSet<Long> set = new TreeSet<>();
		 set.add(4L);
		 set.add(2L);
		 set.add(1L);
		 
		 Long num = new Long(1);
		 Long floor = set.floor(num);
		 Long ceil = set.ceiling(num);
		 
		 System.out.println(floor+" "+ceil);
		 Integer va = new Integer(0);
		 int bn = va;
		 System.out.println(va);
		 
		 String str = "023";
		 System.out.println(Integer.valueOf(str));
	}
}
