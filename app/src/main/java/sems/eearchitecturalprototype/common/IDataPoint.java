package sems.eearchitecturalprototype.common;

/**
 * POJO representing a data point in time, with associated GPS coordinates, speed, and cell ID.
 */
public interface IDataPoint {

    double getLat();

    double getLon();

    long getTimeStamp();

}
