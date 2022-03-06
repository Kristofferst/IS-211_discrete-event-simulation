package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;
import IS211.GeneralEventSimulator.EventSim;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static final int NUM_CHECKOUTS = 3;
    public static final int NUM_CUSTOMERS = 50;

    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i);
        customers = new ArrayList<>();
        init = new ArrayList<>();
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer c = new Customer(this, i);
            init.add(new Event_1_BeginShopping(c));
            customers.add(c);
        }
    }

    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
    }

    public Checkout getCheckoutByShortestQueue(){
        Checkout returnCheckout = null;
        for (Checkout checkout:checkouts){
            if(returnCheckout==null){
                returnCheckout = checkout;
            }
            else{
                if(checkout.getCustomerQueue().size()==0){
                    return checkout;
                }
                if(returnCheckout.getCustomerQueue().size()>checkout.getCustomerQueue().size())
                    returnCheckout = checkout;
            }
        }
        return returnCheckout;
    }
}
