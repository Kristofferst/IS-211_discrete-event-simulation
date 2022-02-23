package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;
import IS211.GeneralEventSimulator.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class EndShoppingEvent extends Event {
    Customer customer;


    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }

    //TODO: Remove printing of TimeEventHappens - unless it gets useful later.
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ "{ TimeEventHappens:" + getTimeEventHappens() + " " + customer
                + " " + customer.shoppingDuration + '}';
    }

}
