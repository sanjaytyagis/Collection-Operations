package CollectionWorkspace;
import java.util.*;
import java.util.stream.Collectors;

/*
 List<Person> listOfPeople = new ArrayList<Person>();
		
		listOfPeople.add(new Person(5, "Sanjay" ,500.0));
		listOfPeople.add(new Person(3, "Pakhi" ,100.0));
		listOfPeople.add(new Person(1, "Bhavana" ,400.0));
		listOfPeople.add(new Person(1, "Meera" ,200.0));
		listOfPeople.add(new Person(4, "Bijender" ,300.0));
		
		Map<Integer, List<Person>> result; 
		result = listOfPeople.stream().collect(Collectors.groupingBy(Person :: getId));	
		//System.out.print(result.toString());
		
		Map<Integer, Long> result; 
		result = listOfPeople.stream().collect(Collectors.groupingBy(Person :: getId,Collectors.counting()));	
		
		result.forEach((a,b)->{
			System.out.print(a+"   "+b.toString()+"\n");
		});
 */
 class Employee {

    public int id;
    public String name;
    public int salary;

    Employee(int id, String name, int salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;

    }
}

public class GroupByObjectsData {

	public static Map<Integer, List<Employee>> getDataCollection(List<Employee> emp) {
		
		Map<Integer, List<Employee>> map = new HashMap();

		for (Employee employee : emp) {
			
		    int key  = employee.id;
		    
		    if(map.containsKey(key))
		       map.get(key).add(employee);
		    else{
		        List<Employee> list = new ArrayList<Employee>();
		        list.add(employee);
		        map.put(key, list);
		    }
		}
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> personList = new ArrayList();
		
		personList.add(new Employee(3,"Sanjay",10)); personList.add(new Employee(3,"Tyagi",20));
		personList.add(new Employee(3,"Monika",30)); personList.add(new Employee(2,"Wavre",40));
		personList.add(new Employee(2,"Mandar",50));
		personList.add(new Employee(2,"Ajith",60)); personList.add(new Employee(1,"Anand",70));
		personList.add(new Employee(1,"Priya",80)); personList.add(new Employee(1,"Ranjan",90));
		personList.add(new Employee(4,"Pooja",100));
		
		Map<Integer, List<Employee>> result = GroupByObjectsData.getDataCollection(personList);
		
		for(int ret : result.keySet()) {
			List<Employee> obj = result.get(ret);
			
			for(Employee e : obj)
			System.out.print(e.id+" "+e.name+" "+e.salary+"  ");
			System.out.println();
		}
	}
}
