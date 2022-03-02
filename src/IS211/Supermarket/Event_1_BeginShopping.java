package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;


/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class Event_1_BeginShopping extends Event {
    Customer customer;


    public Event_1_BeginShopping(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        return new Event_2_EndShopping(customer);
    }

    @Override
    public String toString() {
        return ""+customer +" starts shopping";
    }
}
