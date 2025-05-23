/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.StorageLocation; 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


/**
 *
 * @author JorgeDuarte
 */
public class LocationController {



    /**
     * Valida el formato del ID de un aeropuerto (XXX: 3 letras mayúsculas).
     * @param airportId El ID a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    private static boolean isValidAirportIdFormat(String airportId) {
        if (airportId == null || airportId.length() != 3) {
            return false; 
        }
        for (int i = 0; i < 3; i++) {
            char c = airportId.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false; 
            }
        }
        return true;
    }
    
    private static boolean isValidLatitude(double latitude) { 
        return latitude >= -90 && latitude <= 90; 
    }
    private static boolean isValidLongitude(double longitude) { 
        return longitude >= -180 && longitude <= 180; 
    }
    private static double roundToFourDecimals(double value) {
        return BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }
    private static int countDecimalPlaces(double value) {
        String stringValue = Double.toString(Math.abs(value));
        int integerPlaces = stringValue.indexOf('.');
        if (integerPlaces < 0) {
            return 0; 
        } else {
            return stringValue.length() - integerPlaces - 1;
        }
    }

    public static Response createLocation(String airportId, String airportName, String airportCity, String airportCountry, String airportLatitude, String airportLongitude) {
        try {
            if (!isValidAirportIdFormat(airportId)) {
                return new Response("Airport ID must be 3 uppercase letters.", Status.BAD_REQUEST);
            }
            if (airportName == null || airportName.trim().isEmpty()) {
                return new Response("Airport name must not be empty.", Status.BAD_REQUEST);
            }
            if (airportCity == null || airportCity.trim().isEmpty()) {
                return new Response("Airport city must not be empty.", Status.BAD_REQUEST);
            }
            if (airportCountry == null || airportCountry.trim().isEmpty()) {
                return new Response("Airport country must not be empty.", Status.BAD_REQUEST);
            }

            if (!isValidLatitude(airportLatitude)) {
                return new Response("Latitude must be between -90 and 90.", Status.BAD_REQUEST);
            }
            if (countDecimalPlaces(airportLatitude) > 4) {
                return new Response("Latitude must have at most 4 decimal places.", Status.BAD_REQUEST);
            }
            if (!isValidLongitude(airportLongitude)) {
                return new Response("Longitude must be between -180 and 180.", Status.BAD_REQUEST);
            }
            if (countDecimalPlaces(airportLongitude) > 4) {
                return new Response("Longitude must have at most 4 decimal places.", Status.BAD_REQUEST);
            }
            
            double roundedLatitude = roundToFourDecimals(airportLatitude);
            double roundedLongitude = roundToFourDecimals(airportLongitude);

            StorageLocation storage = StorageLocation.getInstance();
            Location newLocation = new Location(airportId, airportName.trim(), airportCity.trim(), airportCountry.trim(), roundedLatitude, roundedLongitude);

            if (!storage.addLocation(newLocation)) {
                return new Response("An airport with that ID already exists.", Status.BAD_REQUEST);
            }
            return new Response("Airport (Location) created successfully.", Status.CREATED, new Location(newLocation));
        } catch (Exception ex) {
            return new Response("Unexpected error creating location: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getLocationById(String airportId) {
        if (!isValidAirportIdFormat(airportId)) {
            return new Response("Airport ID must be 3 uppercase letters.", Status.BAD_REQUEST);
        }
        StorageLocation storage = StorageLocation.getInstance();
        Location location = storage.getLocation(airportId); 
        if (location == null) {
            return new Response("Airport (Location) not found.", Status.NOT_FOUND);
        }
        return new Response("Airport (Location) retrieved successfully.", Status.OK, location);
    }

    public static Response getAllLocations() {
        try {
            StorageLocation storage = StorageLocation.getInstance();
            List<Location> locations = storage.getAllLocations(); 
            return new Response("Airports (Locations) retrieved successfully.", Status.OK, locations);
        } catch (Exception ex) {
            return new Response("Unexpected error retrieving locations: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}