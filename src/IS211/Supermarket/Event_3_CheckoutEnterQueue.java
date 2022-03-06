package IS211.Supermarket;

import IS211.GeneralEventSimulator.Event;

public class Event_3_CheckoutEnterQueue extends Event {
    Customer customer;
    Checkout checkout;

    public Event_3_CheckoutEnterQueue(Customer customer) {
        super(customer.endShoppingTime+1);
        this.customer = customer;
    }

    @Override
    public Event happen()
    {
        customer.selectCheckout();
        checkout = customer.getCheckout();
        customer.checkoutDuration = checkout.calculateCheckoutDuration(customer.numProducts);
        customer.checkoutTime = customer.endShoppingTime+1+checkout.calculateQueueDelay(customer);
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration+1;
        customer.queueWaitDuration = checkout.calculateQueueDelay(customer);
        checkout.addCustomerToQueue(customer);

        return new Event_4_Checkout(customer, checkout);
    }

    @Override
    public String toString() {
        if(checkout==null)
            return customer +" will enter queue";
        else
            return customer + " enters queue for "+checkout;
    }
}
