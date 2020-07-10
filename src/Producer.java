/***This class represents the bread producers (the manufacturer which is in a different area than the store, 
 * thus it takes time for the producers to get the bread to the store for display.
 * The producer is also implemented as a separate thread as it is independent from the worker's thread.

 * 
 * @author Kirin
 *
 */
public class Producer extends Thread {
	public void run() {
		while(Store.isOpen()) {
		System.out.println("Baking...");
		while(Supply.total == 100) {//while loop to prevent race conditions. IF the supply arrayqueue is full, then stay on the waitlist.
			try{
				wait();
			}catch(InterruptedException e) {
				
			}
			notifyAll();//if interrupted while on the wait list, notify all threads on the waitlist and move back to the locklist
		}
		if(Supply.total <100) {
		Store.bake();
		
		}
		}
	}

}
