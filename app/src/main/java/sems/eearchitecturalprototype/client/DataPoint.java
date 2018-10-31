package sems.eearchitecturalprototype.client;

import sems.eearchitecturalprototype.common.IDataPoint;

public class DataPoint implements IDataPoint {

    private final double lat;
    private final double lon;
    private final long timeStamp;

    public DataPoint(double lat, double lon, long timeStamp) {
        this.lat = lat;
        this.lon = lon;
        this.timeStamp = timeStamp;
    }

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public double getLon() {
        return lon;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

}
