package sems.eearchitecturalprototype.server;

import java.util.List;

import sems.eearchitecturalprototype.common.IDataPoint;
import sems.eearchitecturalprototype.server.interfaces.IDynamicDutyCycleCalculator;

public class DummyDynamicDutyCycleCalculator implements IDynamicDutyCycleCalculator {

    @Override
    public int calculateDutyCycle(List<IDataPoint> previousDataPoints) {
        return (int) (Math.random() * 20) + 1;
    }

}
