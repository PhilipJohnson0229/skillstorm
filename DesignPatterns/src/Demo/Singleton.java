package Demo;

/**
 * ONLY 1 instance of this bean.. ever
 * 
 * Stateless - doesn't store any application state, usually does processing
 * 
 */
public class Singleton {

	//when the app starts up this is always intialized to null
	private static Singleton INSTANCE;
	//this vanilla object is used to synchronize our threads
	private static Object lock = new Object();

	// Eagerly loaded singleton - load when the Classloader starts (pre-main)
	//if we eagerly load every component at startup then  the app will take forever to start
	//good for components that don't exist right away but we need for the app to start like a database
	// static initializer / block
	/*
	 * static { INSTANCE = new Singleton(); }
	 */
	// Ctrl+Shift+/ comment // Ctrl+Shift+\ uncomment
	// * do not push commented code in production
	// no one can call the constructor directly
	private Singleton() {

	}

	//good for components that arent mandatory
	//like for the first time a user sends requests so now we need to call the object when we ask for it
	//that means typically after the app has already started
	//this is a good way to optimize start up loading time
	// Lazy loaded singleton (flawed)
	public static Singleton getInstance() {
		
		//the synchronized keyword will give priority to the first thread to call it
		//only one thread will be able to call this code at a time
		//this is to safeguard the race condition between multiple threads
		//this is a synchronized lock, it requires an object

		synchronized (lock) {
			if(INSTANCE == null) {
				INSTANCE = new Singleton();
			}
		}
		
		
		
		return INSTANCE;
	}
	
}

