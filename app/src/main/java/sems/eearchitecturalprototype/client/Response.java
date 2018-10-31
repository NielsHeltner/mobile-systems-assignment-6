package sems.eearchitecturalprototype.client;

import java.util.ArrayList;
import java.util.List;

import sems.eearchitecturalprototype.common.IClient;
import sems.eearchitecturalprototype.common.IDataPoint;
import sems.eearchitecturalprototype.common.IResponse;

public class Response implements IResponse {

    private IClient sender;
    private List<IDataPoint> dataPoints;

    public Response(IClient sender, List<IDataPoint> dataPoints) {
        this.sender = sender;
        this.dataPoints = new ArrayList(dataPoints);
    }

    @Override
    public IClient getSender() {
        return sender;
    }

    @Override
    public List<IDataPoint> getDataPoints() {
        return dataPoints;
    }

}
