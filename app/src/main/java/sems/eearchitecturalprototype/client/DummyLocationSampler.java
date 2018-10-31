package sems.eearchitecturalprototype.client;

import sems.eearchitecturalprototype.client.interfaces.ILocationSampler;
import sems.eearchitecturalprototype.common.IDataPoint;

public class DummyLocationSampler implements ILocationSampler {

    @Override
    public IDataPoint sampleLocation() {
        return new DataPoint(50.0, 10.0, 123456789);
    }

}
