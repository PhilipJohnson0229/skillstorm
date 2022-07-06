package collections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		// sorted queue
		Queue<Employee> queue = new PriorityQueue<>(); // maintaining natural order as we add elements
		queue.add( new Employee(3, "Berhe", "Amare"));
		queue.add(new Employee(4, "Alina", "Korsunska"));
		queue.add(new Employee(1, "Dan", "Pickles"));
		queue.add(new Employee(2, "Kevin", "Aofia"));
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
	
}
