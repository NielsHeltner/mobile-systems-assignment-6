package sems.eearchitecturalprototype.client.interfaces;

import sems.eearchitecturalprototype.common.IDataPoint;

public interface ILocationSampler {

    /**
     * Samples the mobile device's current location as a data point
     * @return the mobile device's current location
     */
    IDataPoint sampleLocation();

}
