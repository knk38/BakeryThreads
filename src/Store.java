/***
 * This class represents the store and is the main method for the entire bakery implementation.'
 * 
 * -supply: An ArrayQueue that represents the supply of bread for the bakery. It is implemented as a queue 
 * so that there is not waste from newer bread being sold before older bread objects. Look at Supply.java for more documentation
 * 
 * -storeOpen: This boolean field is used by the other threads and isOpen() method to control when the producer and store worker 
 * threads can operate. If !storeOpen the application will close. It can also be force quit by typing "close" into console
 * 
 * -gui: the Gui object that controls the Java application window that opens up and provides a user friendly interpretation of the bakery.
 * Look at Storefront.java for more specifics.
 * 
 * -bake(): creates a new bread object and adds it to the supply ArrayQueue 
 * I decided to synchronize the bake() method to prevent collisions with the store worker and the producers.
 * The producer must wait until the worker has received the shipment before starting a new one.
 * The delay is 10000 ms (10 seconds)
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Store {
	
	static Supply<Bread> supply;
	static Scanner scanner = new Scanner(System.in);
	static boolean storeOpen = true;
	static Storefront gui = new Storefront();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		supply = new Supply(100);
		Output o = new Output();
		o.setDaemon(true); // set the worker to be a low-priority thread. Prioritize recieving shipments over posting supply to storefront
		o.start();
		
		while(scanner.nextLine() != "close") {
			System.out.print("pee");
			
		}
		
		
	}
	
	synchronized static void bake() {
		//while(Store.isOpen()) {
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Bread newbread = new Bread();
		Store.supply.put(newbread);
		System.out.println("Done");
		//}
	}
	
	synchronized static void buy() {
		
	}


	public static boolean isOpen() {
		// TODO Auto-generated method stub
		return storeOpen;
	}

}
