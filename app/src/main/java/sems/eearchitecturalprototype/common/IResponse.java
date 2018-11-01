package sems.eearchitecturalprototype.common;

import java.util.List;

public interface IResponse {

    /**
     * Gets a reference to the client that sent this response
     * @return the client that sent this response
     */
    IClient getSender();

    /**
     * Gets the list of data points of this response
     * @return the list of data points contained in this response
     */
    List<IDataPoint> getDataPoints();

}
