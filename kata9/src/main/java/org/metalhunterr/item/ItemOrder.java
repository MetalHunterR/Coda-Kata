package org.metalhunterr.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.metalhunterr.strategy.PriceStrategy;

import java.security.InvalidParameterException;

@Data
@AllArgsConstructor
public class ItemOrder {

    private Item orderedItem;

    private double itemAmount;

    private PriceStrategy priceStrategy;

    public void addItemToOrder(double amount) {
        if (amount < 1) {
            throw new InvalidParameterException();
        }

        itemAmount += amount;
    }

    public double getTotalPrice() {
        return priceStrategy.getTotalPriceOfOrder(this);
    }
}
