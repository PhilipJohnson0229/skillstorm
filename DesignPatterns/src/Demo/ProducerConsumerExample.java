package Demo;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

	public static void main(String[] args) {
		ThreadsafeBuffer<String> buffer = new ThreadsafeBuffer();
		// producer  = adds stuff to qeue
		new Thread(() -> {
			while (true) {
				try {
					buffer.add("Hello");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// consumer () -> {} takes stuff from qeue
		new Thread(() -> {
			while (true) {
				try {
					System.out.println(buffer.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}

// data structure    -- LinkedList<E>    HashMap<K, V>  
class ThreadsafeBuffer<E> {

	Queue<E> buffer = new LinkedList<>();
	int capacity = 4; // buffer cannot have infinite capacity..

	// consumer - synchronizing on *this*
	public synchronized E take() throws InterruptedException {
		// can't take when buffer is empty
		while (buffer.isEmpty()) {
			wait(); // release the lock - IllegalMonitorStateException (no lock to release)
		}

		E obj = buffer.poll();
		System.out.println("Removed Object");
		notify(); // I took something, it's not full anymore
		return obj;
	}

	// producer - synchronized(this)
	public void add(E obj) throws InterruptedException {
		synchronized (this) {
			// can't overflow the buffer
			while (buffer.size() >= capacity) {
				wait();
			}
			buffer.add(obj);
			System.out.println("Added object");
			notify(); // hey, you've waited long enough, there's something in the buffer
		}
	}
	// java.util.concurrent BlockingQueue (I) - ArrayBlockingQueue
}
