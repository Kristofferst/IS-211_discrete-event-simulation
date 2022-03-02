package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;

public class Event_5_LeaveStore extends Event {
    Customer customer;
    Checkout checkout;

    public Event_5_LeaveStore(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
        checkout = customer.getCheckout();
    }

    @Override
    public Event happen() {
        checkout.getCustomerQueue().remove(customer);
        return null;
    }

    @Override
    public String toString() {
        return customer +" leaves store";
    }
}
