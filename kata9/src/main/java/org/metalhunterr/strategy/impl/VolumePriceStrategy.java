package org.metalhunterr.strategy.impl;

import lombok.AllArgsConstructor;
import org.metalhunterr.item.ItemOrder;

@AllArgsConstructor
public class VolumePriceStrategy extends BasicPriceStrategy {

    private double volumeThreshold;
    private double volumePrice;

    @Override
    public double getTotalPriceOfOrder(ItemOrder order) {
        double basePrice = super.getTotalPriceOfOrder(order);
        double discount = 0;

        // https://www.paddle.com/blog/volume-discount-pricing
        // https://www.mageworx.com/blog/volume-discount-pricing-formulas
        if (order.getItemAmount() >= volumeThreshold) {
            discount = volumeThreshold * order.getOrderedItem().getItemPrice() - volumePrice;
        }
        return basePrice - discount;
    }
}
