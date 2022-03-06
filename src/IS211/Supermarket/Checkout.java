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
    private int totalQueueWaitTime;
    private int greatestQueueWaitTime;
    private int greatestQueueSize;
    private int servedCustomers;
    private int sizeOnEntry;

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

    public void addCustomerToQueue(Customer customer){
        customerQueue.add(customer);
        setIfGreatestQueueSize(customerQueue.size());
        sizeOnEntry += customerQueue.size();
    }

    private void setIfGreatestQueueSize(int size) {
        if(size > greatestQueueSize)
            greatestQueueSize = size;
    }

    private void setIfGreatestQueueWaitTime(int queueWaitDuration) {
        if(queueWaitDuration > greatestQueueWaitTime)
            greatestQueueWaitTime = queueWaitDuration;
    }

    public void serveCustomer(Customer customer){
        customerQueue.remove(customer);
        servedCustomers++;
        setIfGreatestQueueWaitTime(customer.queueWaitDuration);
        totalQueueWaitTime += customer.queueWaitDuration;
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

    public String statsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("totalQueueWaitTime: ");
        stringBuilder.append(totalQueueWaitTime);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("greatestQueueWaitTime: ");
        stringBuilder.append(greatestQueueWaitTime);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("averageQueueWaitTime: ");
        stringBuilder.append(totalQueueWaitTime/servedCustomers);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("greatestQueueSize: ");
        stringBuilder.append(greatestQueueSize);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("averageSizeOnEntry: ");
        stringBuilder.append(sizeOnEntry/servedCustomers);
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
