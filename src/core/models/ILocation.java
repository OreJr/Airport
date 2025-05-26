package core.models;

import core.utils.CopyContext;

public interface ILocation {
    String getAirportId();
    String getAirportName();
    String getAirportCity();
    String getAirportCountry();
    double getAirportLatitude();
    double getAirportLongitude();
    
    ILocation copy(CopyContext context);
    default ILocation copy() {
        return copy(new CopyContext());
    }
}