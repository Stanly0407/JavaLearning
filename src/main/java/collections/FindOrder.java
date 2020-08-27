package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindOrder {

    public List<Order> findBiggerAmountOrder(float bigAmount, List<Order> orders) {

        ArrayList bigPrices = new ArrayList();
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order current = iterator.next();
            if (current.getAmount() >= bigAmount) {
                bigPrices.add(current);
            }
        }
        return bigPrices;
    }

}
