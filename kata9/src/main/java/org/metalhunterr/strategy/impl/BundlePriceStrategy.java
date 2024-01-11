package org.metalhunterr.strategy.impl;

import lombok.AllArgsConstructor;
import org.metalhunterr.item.ItemOrder;
import org.metalhunterr.strategy.PriceStrategy;

@AllArgsConstructor
public class BundlePriceStrategy implements PriceStrategy {

    private int bundleThreshold;
    private double bundlePrice;

    @Override
    public double getTotalPriceOfOrder(ItemOrder order) {
        double fullPricedItems = (order.getItemAmount() % bundleThreshold) * order.getOrderedItem().getItemPrice();
        double discountedPrice = (double) (order.getItemAmount() / bundleThreshold) * bundlePrice;

        return fullPricedItems + discountedPrice;
    }
}
