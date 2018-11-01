package sems.eearchitecturalprototype.server.interfaces;

import java.util.List;

import sems.eearchitecturalprototype.common.IDataPoint;

public interface IDynamicDutyCycleCalculator {

    /**
     * Calculates a new duty cycle interval based on the previous data points
     * @param previousDataPoints the previous data points received from the client
     * @return the new duty cycle interval the client should use
     */
    int calculateDutyCycle(List<IDataPoint> previousDataPoints);

}
