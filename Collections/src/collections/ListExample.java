package collections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		// generics - enforce the type at compile-time
		Employee employee = new Employee(3, "Berhe", "Amare");
		java.util.List<Employee> linkedList = new ArrayList<>();
		linkedList.add(new Employee(1, "Alina", "Korsunska"));
		linkedList.add(new Employee(2, "Kevin", "Aofia"));
		//these are duplicates and they WILL take up a spot in the list
		linkedList.add(employee);
		linkedList.add(employee);
		linkedList.add(employee);
		linkedList.add(employee); // duplicates allowed
		
		//this will return 6 because duplicates are allowed
		System.out.println(linkedList.size());
		
		
		// raw
		List list = new ArrayList();
		list.add("String");
		list.add(100);
		list.add(new Employee());
		
		System.out.println(list);
	}

}
