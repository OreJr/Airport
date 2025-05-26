package core.models;

import core.utils.CopyContext;

public class Location implements ILocation {
    
    private final String airportId;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private double airportLatitude;
    private double airportLongitude;

    public Location(String airportId, String airportName, String airportCity, String airportCountry, double airportLatitude, double airportLongitude) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
        this.airportLatitude = airportLatitude;
        this.airportLongitude = airportLongitude;
    }

    @Override
    public String getAirportId() { return airportId; }
    @Override
    public String getAirportName() { return airportName; }
    @Override
    public String getAirportCity() { return airportCity; }
    @Override
    public String getAirportCountry() { return airportCountry; }
    @Override
    public double getAirportLatitude() { return airportLatitude; }
    @Override
    public double getAirportLongitude() { return airportLongitude; }

    @Override
    public ILocation copy(CopyContext context) {
        ILocation existingCopy = context.getCopied(this);
        if (existingCopy != null) {
            return existingCopy;
        }
        Location newLocation = new Location(this.airportId, this.airportName, this.airportCity, this.airportCountry, this.airportLatitude, this.airportLongitude);
        context.registerCopy(this, newLocation);
        return newLocation;
    }
}