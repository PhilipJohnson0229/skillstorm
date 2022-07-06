package Demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample2 {

	public static void main(String[] args) {
		// thread synchronization is handled already
		BlockingQueue<Object> buffer = new ArrayBlockingQueue<>(4);
		// producer
		new Thread(()->{
			while(true)
				try {
					buffer.put(new Object());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
		// consumer
		new Thread(()->{
			while(true)
				try {
					System.out.println(buffer.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
	}

}
