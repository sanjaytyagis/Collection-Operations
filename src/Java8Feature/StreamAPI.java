package Java8Feature;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
/*
-> Filtering and Counting: Given a list of integers, how would you use Java 8 Stream API to filter out the even numbers and count them?
-> Mapping and Summing: Suppose you have a list of Product objects where each product has a price. How would you use Java 8 Stream API to find the total price of all products?
-> Grouping and Aggregating: Imagine you have a list of Person objects with their ages. How would you use Java 8 Stream API to group the people by their age and count the number of people in each age group?
-> Sorting and Limiting: Given a list of strings representing names, how would you use Java 8 Stream API to sort the names alphabetically and retrieve only the first 5 names?
-> Mapping and Collecting: Suppose you have a list of Employee objects, and you want to extract only their names into a new list. How would you achieve this using Java 8 Stream API?
-> FlatMapping: Consider a scenario where you have a list of orders, and each order contains a list of items. How would you use Java 8 Stream API to flatten this structure and get a list of all items across all orders?
-> Combining Operations: Suppose you have a list of transactions with transaction amounts. How would you use Java 8 Stream API to filter out the transactions with amounts greater than $100, sum their amounts, and then calculate the average of these amounts?
-> Parallel Stream Processing: When would you consider using parallel streams over sequential streams, and what are the potential benefits and drawbacks of using parallel streams?
 */
public class StreamAPI {

	/*Stream<String> stream = Stream.of("Geeks", "for", "Geeks"); 
	 Stream<Person> personStream = Stream.of( new Person("Johnny", 11),new Person("Ivy", 13),
            new Person("Rick", 12)
        );
	 */
	public static void main(String[] args) {
		
// Flat Map	
List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4,5),Arrays.asList(6, 7, 8));

List<Integer> flattenedList = listOfLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		
System.out.println("Flat Map "+flattenedList.toString());

// ++++++++++++ Example1 +++++++++++++++++++++++++++++++++++
		List<Integer> names = Arrays.asList(1,2,3,4,5);
		
		//grouping
		Map<Integer, Long> result = names.stream().collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );

		// getDisctinct
		List<Integer> ans = names.stream().distinct().collect(Collectors.toList());
		
		// Sort in Ascending
		List<Integer> sortedAsc = names.stream().sorted().collect(Collectors.toList());
		List<Integer> sortedlamb = names.stream().sorted((Integer a,Integer b)-> {return a-b;}).collect(Collectors.toList());
		List<Integer> sortedla = names.stream().sorted((Integer a,Integer b)-> a-b).collect(Collectors.toList());
		
		// Sort in Descending
		List<Integer> sortedDesc = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
		// Filter the Stream
        List<Integer> FilterExample = names.stream().filter(num -> num%2==0).sorted().collect(Collectors.toList());
        //FilterExample.forEach(System.out::println);
        
        // Map in the Stream
        List<Integer> MapExample = names.stream().map(num -> num*num).sorted().collect(Collectors.toList());
        //MapExample.forEach(System.out::println);
        
        // Reduce the Stream to get Sum       reduce(accumulator, element)
        int ReduceExampleSUM = names.stream().reduce(0, (element1, element2) -> element1 + element2);
        //System.out.println(ReduceExampleSUM);
        
        // Reduce the Stream to get Max Num
        Optional<Integer> ReduceExamplelongest = names.stream().reduce((word1, word2) -> word1 > word2 ? word1 : word2);
        if(ReduceExamplelongest.isPresent()){
        	System.out.println("Reduce "+ReduceExamplelongest.get());
        }
        
        // Reduce the Stream to get Concatenate
        String[] array = { "Geeks", "for", "Geeks" };
        Optional<String> String_combine = Arrays.stream(array).reduce((str1, str2) -> str1 + "-" + str2);
       
        
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        }
        
        // The peek() method returns a stream consisting of the elements of the stream after performing the provided action on each element
        List<Integer> getPeek = names.stream().filter(value -> value % 2 == 0).peek(value -> System.out.println("Filtered " + value))
                .map(value -> value * 10).collect(Collectors.toList());
        
        //The limit() method returns a stream with the stream elements limited to the provided size.
        List<Integer> getLimited = names.stream().limit(3).collect(Collectors.toList());
        
      //This skip() method returns a stream consisting of the stream after discarding the provided first n elements.
        List<Integer> getSkip = names.stream() .skip(2).collect(Collectors.toList());
        
        //The count() method returns the total number of elements in the stream.
        final long count = names.stream().count();
        
        //The toArray() method returns an array that contains the elements of the stream.
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(Arrays.toString(stream.toArray()));

        
// ++++++++++++ Example2 +++++++++++++++++++++++++++++++++++
        HashMap<String,Integer> months = new HashMap<>();
        //Declaring a hash map and adding key-value pairs
        months.put("January",31);
        months.put("April",30);
        months.put("September",30);
        months.put("July",31);
        months.put("February",28);
        months.put("December",31);

        months.forEach((month,days)->{
            if(month == "September") { // if month has 31 days, printing month
                //System.out.println(30);
            }
        });
	}

}
