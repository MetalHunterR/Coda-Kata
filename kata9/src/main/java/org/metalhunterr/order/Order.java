package org.metalhunterr.order;

import org.metalhunterr.item.ItemOrder;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<ItemOrder> orders = new ArrayList<>();

    public void addItemToList(ItemOrder itemOrder) {
        ItemOrder foundItem = orders.stream()
                .filter(x -> x.getOrderedItem().equals(itemOrder.getOrderedItem()))
                .findFirst().orElse(null);

        if (foundItem != null) {
            foundItem.addItemToOrder(itemOrder.getItemAmount());
        } else {
            orders.add(itemOrder);
        }
    }

    public double getTotalPrice() {
        double result = 0.0;

        for (ItemOrder order : orders) {
            result += order.getTotalPrice();
        }
        return result;
    }
}
