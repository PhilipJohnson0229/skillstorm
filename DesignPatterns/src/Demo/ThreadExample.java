package Demo;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		int number = 100;

		SeparateTask task = new SeparateTask(number);
		Thread thread = new Thread(task);
		thread.start(); // new stack, starts that stack concurrently with run method as the base
		
		//Thread.sleep(1000);  // main thread
		thread.join();	
		System.out.println(task.value);
	}

	// lightweight process

}

//Functional Interface (defines 1 method only)
// Marker interface (defines NO methods)
class SeparateTask implements Runnable {

	public int value;

	public SeparateTask(int value) {
		this.value = value;
	}

	public void run() {
		System.out.println(this.value++);
	}

}