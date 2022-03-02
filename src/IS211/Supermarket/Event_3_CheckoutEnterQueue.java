package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;

public class Event_3_CheckoutEnterQueue extends Event {
    Customer customer;
    Checkout checkout;

    public Event_3_CheckoutEnterQueue(Customer customer) {
        super(customer.endShoppingTime);
        this.customer = customer;
    }

    @Override
    public Event happen()
    {
        customer.selectCheckout();
        checkout = customer.getCheckout();
        customer.checkoutDuration = checkout.calculateCheckoutDuration(customer.numProducts);
        customer.checkoutTime = customer.endShoppingTime+1+checkout.calculateQueueDelay(customer);
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.queueWaitDuration = checkout.calculateQueueDelay(customer);
        checkout.getCustomerQueue().add(customer);

        return new Event_4_Checkout(customer, checkout);
    }

    @Override
    public String toString() {
        if(checkout==null)
            return customer +" enters queue";
        else
            return customer + " enters queue for "+checkout;
    }
}
