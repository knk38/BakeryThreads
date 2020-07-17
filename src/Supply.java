
public class Supply<T> {
    /*** Represents a supply ArrayQueue that stores Bread objects b: the array with length s that
     * stores Bread h: the index of the first element in the queue n: the total number of Bread
     * objects in supply */
    Bread[] b;
    int h; // first element
    static int n; // # of elements
    static int total;

    @SuppressWarnings("unchecked")
    /*** Creates a new Bread supply object with max capacity s
     * 
     * @param s size of Array */
    public Supply(int s) {
        b= new Bread[s];
    }

    /*** Adds a Bread object to the Supply (uses wraparound to store objects) Precondition: Supply
     * is not full
     * 
     * @param newbread */
    public void put(Bread newbread) {
        b[(h + n) % b.length]= newbread;
        n= n + 1;
        total+= newbread.loaves;
    }

    public Bread get() {
        Bread gotten= b[h];
        h= (h + 1) % b.length;
        n= n - 1;
        return gotten;

    }

    @Override
    public String toString() {
        if (n == 0) return "0";
        String output= "[";
        for (Bread obj : b) {
            if (obj != null) {
                output+= obj.loaves + ", ";
            }
        }
        output+= " ]";
        return output;
    }

    public int toInt() {
        return total;
    }
}
