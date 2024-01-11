package org.metalhunterr.strategy;

import org.metalhunterr.item.ItemOrder;

public interface PriceStrategy {
    double getTotalPriceOfOrder(ItemOrder order);
}
