package IS211;

import IS211.Supermarket.Checkout;
import IS211.Supermarket.SuperMarket;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();
        superMarket.startSim();

        for(Checkout checkout : superMarket.getCheckouts()){
            System.out.println(checkout + ":");
            System.out.println(checkout.statsAsString());
        }
    }
}