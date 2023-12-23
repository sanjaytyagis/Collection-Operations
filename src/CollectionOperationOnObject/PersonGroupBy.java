package CollectionOperationOnObject;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonGroupBy {

	public static void main(String[] args) {
		
		List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> ans =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        ans.forEach((key,value)
				->{
					System.err.println(key+ " " +ans.get(key));
				}); 
        
		// TODO Auto-generated method stub
		List<Person> listOfPeople = new ArrayList<Person>();
		
		listOfPeople.add(new Person(1, "Sanjay" ,500.0));
		listOfPeople.add(new Person(3, "Pakhi" ,100.0));
		listOfPeople.add(new Person(1, "Bhavana" ,400.0));
		listOfPeople.add(new Person(2, "Meera" ,200.0));
		listOfPeople.add(new Person(2, "Bijender" ,300.0));
		listOfPeople.add(new Person(3, "Vishesh" ,300.0));
		
		// 2.2 Group by the name + Count or Sum the Qty.
		
		Map<Integer, List<Person>> counting = listOfPeople.stream().collect(Collectors.groupingBy(Person :: getId));
		
		counting.forEach((key,value)
				->{
					System.err.println(key+ " "+ counting.get(key));
				});  
		
		Map<Integer, Double> sum = listOfPeople.stream().collect(
                Collectors.groupingBy(Person::getId, Collectors.summingDouble(Person::getSalary)));
		
		sum.forEach((key,value)
				->{
					System.err.println(key+ " "+ sum.get(key));
				}); 
		
		// group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<Integer, List<String>> result =
        		listOfPeople.stream().collect(
                        Collectors.groupingBy(Person::getId,
                                Collectors.mapping(Person::getName, Collectors.toList())
                        )
                );
		
		result.forEach((key,value)
				->{
					System.err.println(key+ " "+result.get(key));
				});
		
	}
}
