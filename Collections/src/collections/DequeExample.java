package collections;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Stack
public class DequeExample {

	public static void main(String[] args) {
		Stack stack = new Stack<>();
		Deque<Employee> queue = new LinkedList<>();
		queue.add( new Employee(3, "Berhe", "Amare"));
		queue.add(new Employee(4, "Alina", "Korsunska"));
		queue.add(new Employee(1, "Dan", "Pickles"));
		queue.add(new Employee(2, "Kevin", "Aofia"));
		
		System.out.println(queue.peekFirst());
		System.out.println(queue.size());
		System.out.println(queue.pollFirst());
		System.out.println(queue.size());
	}

}
