package sems.eearchitecturalprototype.server;

import java.util.List;

import sems.eearchitecturalprototype.common.IDataPoint;

public class DummyDynamicDutyCycleCalculator implements IDynamicDutyCycleCalculator {

    @Override
    public int calculateDutyCycle(List<IDataPoint> previousDataPoints) {
        return 0;
    }

}
