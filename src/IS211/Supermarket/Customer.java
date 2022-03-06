package IS211.Supermarket;

import IS211.GeneralEventSimulator.EventSim;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 500;
    public static final int MIN_PRODUCTS = 1;

    // customer will spend ranom amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 50;
    public static final int MIN_SHOP_TIME = 1;

    SuperMarket shop;
    String name;

    int beginShoppingTime; // Set by random
    int shoppingDuration; // Set by random
    int numProducts; // Set by random
    int endShoppingTime;
    int queueWaitDuration; // Add duration of overlap between this costumer and previous ones
    int checkoutTime; // Sum of endShoppingTime and wait
    int checkoutDuration; // Product of product num and time pr + constant. (Checkout and customer)
    int leaveTime;

    Checkout checkout;


    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = this.getClass().getSimpleName() + "_" + i;
        beginShoppingTime = EventSim.nextInt(0, 50);
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration;
    }

    @Override
    public String toString() {
        return name;
    }

    public Checkout selectCheckout() {
        return this.checkout = shop.getCheckoutByShortestQueue();
    }

    public Checkout getCheckout() {
        return checkout;
    }
}
