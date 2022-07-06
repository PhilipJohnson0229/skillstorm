package Demo;

public class AnonExample {

	public static void main(String[] args) {
		// right here - not reusable
		
		// anonymous inner class - multiple methods in the interface
		// Java 8+ lambda expression - functional interfaces 
		// () -> {}
		Thread thread = new Thread( () -> {
			
		} );
		thread.start();
		
		
		System.out.println("Main");
		
	}
	
}

// Functional interface defines 1 method only
interface Functional {
	public void go();
}