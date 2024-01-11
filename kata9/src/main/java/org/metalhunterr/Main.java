package org.metalhunterr;

import org.metalhunterr.item.Item;
import org.metalhunterr.item.ItemOrder;
import org.metalhunterr.order.Order;
import org.metalhunterr.strategy.PriceStrategy;
import org.metalhunterr.strategy.impl.BasicPriceStrategy;
import org.metalhunterr.strategy.impl.BundlePriceStrategy;
import org.metalhunterr.strategy.impl.VolumePriceStrategy;

public class Main {
    public static void main(String[] args) {
        PriceStrategy regular = new BasicPriceStrategy();
        PriceStrategy bundle = new BundlePriceStrategy(3, 1.99);
        PriceStrategy volume = new VolumePriceStrategy(0.5, 0.99);

        Item cannedBeans = new Item("Canned Beans", 0.99);
        Item apple = new Item("Apple", 0.25);
        Item nuts = new Item("Deez Nuts", 0.19);

        ItemOrder cannedBeansOrder = new ItemOrder(cannedBeans, 7, bundle); // Basic mode: 7 * 0.99 -> 6.93
        ItemOrder appleOrder = new ItemOrder(apple, 6, regular); // Basic mode: 6 * 0.25 -> 1.5
        ItemOrder nutsOrder  = new ItemOrder(nuts, 1.75, volume); // Basic mode: 1.75 * 7 = 1.33 (if nuts default weight is 0.25kg)

        // Basic mode: Total 9.76
        Order finalOrder = new Order();
        finalOrder.addItemToList(cannedBeansOrder);
        finalOrder.addItemToList(appleOrder);
        finalOrder.addItemToList(nutsOrder);

        System.out.println(finalOrder.getTotalPrice());
    }
}