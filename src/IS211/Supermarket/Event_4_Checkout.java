package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;

public class Event_4_Checkout extends Event {
    Customer customer;
    Checkout checkout;

    public Event_4_Checkout(Customer customer, Checkout checkout) {
        super(customer.checkoutTime);
        this.customer = customer;
        this.checkout = checkout;
    }

    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return new Event_5_LeaveStore(customer);
    }

    @Override
    public String toString() {
        return customer + " turn to check out";
    }
}
