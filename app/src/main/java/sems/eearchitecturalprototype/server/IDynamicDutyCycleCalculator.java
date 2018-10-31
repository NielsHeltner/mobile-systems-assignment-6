package sems.eearchitecturalprototype.server;

import java.util.List;

import sems.eearchitecturalprototype.common.IDataPoint;

public interface IDynamicDutyCycleCalculator {

    int calculateDutyCycle(List<IDataPoint> previousDataPoints);

}
