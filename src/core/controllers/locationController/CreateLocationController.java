/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.models.Location;

/**
 *
 * @author OreJr
 */
public class CreateLocationController {
    public static Location createLocation(String airportId, String airportName, String airportCity, String airportCountry, double airportLatitude, double airportLongitude) {
        Location newLocation = new Location(airportId, airportName, airportCity, airportCountry, airportLatitude, airportLongitude);

        return newLocation;
    }
}
