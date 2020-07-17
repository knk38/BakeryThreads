/*** This class represents the bread producers (the manufacturer which is in a different area than
 * the store, thus it takes time for the producers to get the bread to the store for display. The
 * producer is also implemented as a separate thread as it is independent from the worker's thread.
 * 
 * 
 * @author Kirin */
public class Producer extends Thread {
    @Override
    public void run() {
        while (Store.isOpen()) {
            System.out.println("Baking...");
            /** while (Supply.total >= 100) {// while loop to prevent race conditions. IF the supply
             * // arrayqueue is full, then stay on the waitlist. System.out.println("queue full");
             * try { synchronized (this) { this.wait(); }
             * 
             * } catch (InterruptedException e) {
             * 
             * notifyAll();// if interrupted while on the wait list, notify all threads on the //
             * waitlist and move back to the locklist } catch (IllegalMonitorStateException i) {
             * System.out.println("Still waiting"); }
             * 
             * } */
            if (Supply.total < 100) {
                Store.bake();
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else {
                while (Supply.total >= 100) {
                    // do nothing
                }
            }
        }
    }

}
