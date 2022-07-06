package Demo;

public class DoubletonExample {

	public static void main(String[] args) {
		// Lazy-loaded singleton
		new Thread( () -> {
			System.out.println(Singleton.getInstance());
		} ).start();
		
		new Thread( () -> {
			System.out.println(Singleton.getInstance());
		} ).start();
		
	}
	
}
