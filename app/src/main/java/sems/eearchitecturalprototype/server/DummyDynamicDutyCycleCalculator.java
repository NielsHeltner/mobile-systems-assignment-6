package sems.eearchitecturalprototype.server;

import java.util.List;

import sems.eearchitecturalprototype.common.IDataPoint;
import sems.eearchitecturalprototype.server.interfaces.IDynamicDutyCycleCalculator;

public class DummyDynamicDutyCycleCalculator implements IDynamicDutyCycleCalculator {

    /**
     * Dummy implementation of the dynamic cycle interval calculator
     * @param previousDataPoints the previous data points received from the client
     * @return a random integer between 1 and 20, not based on the data points.
     */
    @Override
    public int calculateDutyCycle(List<IDataPoint> previousDataPoints) {
        return (int) (Math.random() * 20) + 1;
    }

}
