package org.metalhunterr.strategy.impl;

import org.metalhunterr.item.ItemOrder;
import org.metalhunterr.strategy.PriceStrategy;

public class BasicPriceStrategy implements PriceStrategy {

    @Override
    public double getTotalPriceOfOrder(ItemOrder order) {
        return order.getOrderedItem().getItemPrice() * order.getItemAmount();
    }
}
