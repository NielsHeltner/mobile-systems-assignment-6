package sems.eearchitecturalprototype.common;

import java.util.List;

public interface IResponse {

    IClient getSender();

    List<IDataPoint> getDataPoints();

}
