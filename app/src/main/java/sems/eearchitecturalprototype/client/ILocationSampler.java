package sems.eearchitecturalprototype.client;

import sems.eearchitecturalprototype.common.IDataPoint;

public interface ILocationSampler {

    /**
     * Returns the mobile device's current location as a data point
     * @return the mobile device's current location
     */
    IDataPoint sampleLocation();

}
