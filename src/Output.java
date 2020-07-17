/*** This class represents the worker at a Bakery putting up the available loaves of bread. It is
 * its own thread, independent from the producer thread and simply posts the available bread objects
 * every 5000 ms (5 seconds) The "worker" only works when the store is open, so a while loop ensures
 * that the print() method, which posts the supply, is only called when the store is open. \
 * 
 * @author Kirin */
public class Output extends Thread {
    @Override
    public void run() {
        while (Store.isOpen()) {
            print();
        }
    }

    public void print() {
        // System.out.format("%s: %s %s \n","Bread Supply",Store.supply.toString(), "Loaves");
        System.out.println("printed" + Store.supply.toInt());
        Store.gui.changeSupply(Store.supply.toInt());
        try {
            this.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
