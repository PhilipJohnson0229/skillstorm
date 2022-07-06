package collections;


import java.util.LinkedHashMap;
import java.util.Map;

// Map - Collection? IS-A no (Map does not implement Collection interface) 
// is a - yes (Map is a collection)
public class MapExample {

	
	// Map<Employee, List<Employee>> accountMap;
	public static void main(String[] args) {
		// HashMap - unordered , unsorted 
		// TreeMap - sorted    
		// LinkedHashMap - ordered (insertion order)
		Map<String, Employee> map = new LinkedHashMap<>();
		map.put("randy", new Employee(3, "Randy", "Scott"));
		map.put("luna", new Employee(63, "David", "Luna"));
		map.put("dan", new Employee(10, "Dan", "Pickles"));
		
		
		//Employee value = map.get("dan");
		
		for(Employee temp: map.values()) {
			System.out.println(temp);
		}
		
	}
	
}
