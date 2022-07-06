package collections;


import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import collections.Employee.FirstNameComparator;

// application component (stateless)
public class SetExample {

	public static void main(String[] args) {
		Employee employee = new Employee(3, "David", "Youngblood");
		
		// instantiating an inner class
		// outer.inner
		 // inner class
		//Employee.FirstNameComparator comparator = new Employee(). new FirstNameComparator();
		Employee.FirstNameComparator comparator = new Employee.FirstNameComparator();
		
		SortedSet<Employee> hashSet = new TreeSet<>(comparator);
		hashSet.add(new Employee(45, "Breanna", "Ransom"));
		hashSet.add(new Employee(1736, "Daniel", "Livingston"));
		hashSet.add( new Employee(12, "David", "Youngblood"));
		
		// Alt+Shift+R   - refactor
		for (Employee temp : hashSet) {
			System.out.println(temp);
		}
	}
	
}
