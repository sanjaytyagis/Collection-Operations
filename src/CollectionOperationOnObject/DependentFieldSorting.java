package CollectionOperationOnObject;
import java.util.*;
import java.util.stream.Collectors;

/*Then comparing Used if there are duplicate Id of person then next sorting will done on the name field basis 
and we can decide second field will be sort ascending or descending
*/

public class DependentFieldSorting {

	public static void main(String[] args) {
		
		/*
		Person person1 = new Person(5, "Sanjay" ,500.0);
        Person person2 = new Person(1, "Pakhi" ,100.0);
        Person person3 = new Person(4, "Bhavana" ,400.0);
        Person person4 = new Person(2, "Meera" ,200.0);
        Person person5 = new Person(3, "Bijender" ,300.0);

        List<Book> unsortredBooksList = Arrays.asList(book1, book2, book3, book4, book5);
		 */
		List<Person> listOfPeople = new ArrayList<Person>();
		
		listOfPeople.add(new Person(5, "Sanjay" ,500.0));
		listOfPeople.add(new Person(3, "Pakhi" ,100.0));
		listOfPeople.add(new Person(1, "Bhavana" ,400.0));
		listOfPeople.add(new Person(1, "Meera" ,200.0));
		listOfPeople.add(new Person(4, "Bijender" ,300.0));
		
		//without Method referencing Comparator.comparing((Person b) -> b.getAuthor())
		
		// Reverse order Comparator.comparing((Person b) -> b.getAuthor(), Comparator.reverseOrder())
		
		// Comparator<Person> comparator2 = (p1, p2) -> p1.getName().compareTo(p2.getName());
		
		// Comparator<Person> comparator2 = (Person p1,Person p2) -> p1.getName().compareTo(p2.getName());
		
		List<Person> result = 
				
		listOfPeople.
		stream().
		sorted(
		Comparator.comparing(Person :: getId).thenComparing(Comparator.comparing(Person :: getName))
		)
		.
		collect(Collectors.toList());
		
		for (Person p : result) {
            System.out.println(p);
        }
	}
}
