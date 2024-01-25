package org.metalhunterr.factory;

import org.metalhunterr.misc.StrategyEnum;
import org.metalhunterr.strategy.PriceStrategy;
import org.metalhunterr.strategy.impl.BasicPriceStrategy;
import org.metalhunterr.strategy.impl.BundlePriceStrategy;
import org.metalhunterr.strategy.impl.VolumePriceStrategy;

public class StrategyFactory {

    public static PriceStrategy factoryGenerateStrategy(StrategyEnum strategyType, Double... args) {
        switch (strategyType) {
            case BASIC_STRATEGY -> {
                return new BasicPriceStrategy();
            }
            case BUNDLE_STRATEGY -> {
                return new BundlePriceStrategy(args[0].intValue(), args[1]);
            }
            case VOLUME_STRATEGY -> {
                return new VolumePriceStrategy(args[0], args[1]);
            }
        }

        // Fail-safe if something is messed up...
        return new BasicPriceStrategy();
    }
}
