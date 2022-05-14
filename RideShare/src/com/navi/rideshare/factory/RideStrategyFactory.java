package com.navi.rideshare.factory;

import com.navi.rideshare.factory.strategy.RideSelectionStrategy;
import com.navi.rideshare.factory.strategy.impl.MostVacantStrategy;
import com.navi.rideshare.factory.strategy.impl.PreferredVehicleStrategy;
import com.navi.rideshare.factory.strategy.impl.UnknownStrategy;
import com.navi.rideshare.model.enums.RideSelectionType;

public class RideStrategyFactory {

    public RideSelectionStrategy findStrategy(RideSelectionType rideSelectionType) {
        return switch (rideSelectionType) {
            case MOST_VACANT -> new MostVacantStrategy();
            case PREFERRED_VEHICLE -> new PreferredVehicleStrategy();
            default -> new UnknownStrategy();
        };
    }
}
