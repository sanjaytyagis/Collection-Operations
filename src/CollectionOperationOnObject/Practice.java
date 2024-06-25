package CollectionOperationOnObject;

import java.util.*;

public class Practice {

	public static boolean check(int n) {
		System.out.println("Hello");
		if(n==3)
			System.out.println("UseFul");
		return true;
	}
	
	public static void main(String[] args) {
		
		Integer arr[] = {1,2,3,4,5};
		int f = 0;
		f = 3>2 ? 3 : 2;
		System.out.println(f);
		// Using Comparator
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		
		// Using Lambda
		Arrays.sort(arr, (Integer a, Integer b) -> {
				return b-a;
			}
		);
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		List<List<Integer>> dbli = new ArrayList<List<Integer>>();	
		
		dbli.add(Arrays.asList(2,6));
		dbli.add(Arrays.asList(1,3));
		dbli.add(Arrays.asList(15,18));
		dbli.add(Arrays.asList(8,10));
		
		Collections.sort(dbli, (List<Integer> a, List<Integer> b)-> {
			return a.get(0)-b.get(0);
		});
		
		System.out.println("Double List "+ dbli.toString());
		
		// Using Lambda
		Collections.sort(list, (Integer a, Integer b)-> {
			return b-a;
		});
		int a = 101 ;
		int b = 001;
		System.out.println(a+b); 	
	}
}
