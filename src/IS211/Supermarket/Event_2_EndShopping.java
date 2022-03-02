package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;
import IS211.GeneralEventSimulator.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class Event_2_EndShopping extends Event {
    final Customer customer;


    public Event_2_EndShopping(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.selectCheckout();
        return new Event_3_CheckoutEnterQueue(customer);
    }

    //TODO: Remove printing of TimeEventHappens - unless it gets useful later.
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ "{ TimeEventHappens:" + getTimeEventHappens() + " " + customer
                + " " + customer.shoppingDuration + '}';
    }

}
