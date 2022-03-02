package IS211.Supermarket;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per product (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd
    private Deque<Customer> customerQueue;

    SuperMarket shop;
    String name;


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout " + i;
        this.customerQueue = new LinkedList<>();
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public int calculateCheckoutDuration(int numProducts){
        return PROD_DURATION*numProducts+PAY_DURATION;
    }

    @Override
    public String toString() {
        return name;
    }

    public int calculateQueueDelay(Customer customer) {
        Customer customerAheadInQueue = customerQueue.peekLast();
        if(customerAheadInQueue == null || customerAheadInQueue.equals(customer)){
            return 0;
        }
        else
            return customerAheadInQueue.leaveTime - customer.endShoppingTime;
    }
}
