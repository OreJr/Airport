/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.StorageLocation;
import core.views.AirportFrame;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author JorgeDuarte
 */
public class LocationController {

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
                return new Response("El ID del aeropuerto debe ser 3 letras mayúsculas.", Status.BAD_REQUEST);
            }
            if (airportName == null || airportName.trim().isEmpty()) {
                return new Response("El nombre del aeropuerto no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (airportCity == null || airportCity.trim().isEmpty()) {
                return new Response("La ciudad del aeropuerto no debe estar vacía.", Status.BAD_REQUEST);
            }
            if (airportCountry == null || airportCountry.trim().isEmpty()) {
                return new Response("El país del aeropuerto no debe estar vacío.", Status.BAD_REQUEST);
            }
            double doubleAirportLatitude;
            double roundedLatitude;
            try {
                doubleAirportLatitude = Double.parseDouble(airportLatitude);
                if (!isValidLatitude(doubleAirportLatitude)) {
                    return new Response("La latitud debe estar entre -90 y 90.", Status.BAD_REQUEST);
                }
                if (countDecimalPlaces(doubleAirportLatitude) > 4) {
                    return new Response("La latitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLatitude = roundToFourDecimals(doubleAirportLatitude);
            } catch (NumberFormatException ex) {
                return new Response("La latitud debe ser numérica.", Status.BAD_REQUEST);
            }
            double doubleAirportLongitude;
            double roundedLongitude;
            try {
                doubleAirportLongitude = Double.parseDouble(airportLongitude);
                if (!isValidLongitude(doubleAirportLongitude)) {
                    return new Response("La longitud debe estar entre -180 y 180.", Status.BAD_REQUEST);
                }
                if (countDecimalPlaces(doubleAirportLongitude) > 4) {
                    return new Response("La longitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLongitude = roundToFourDecimals(doubleAirportLongitude);
            } catch (NumberFormatException ex) {
                return new Response("La longitud debe ser numérica.", Status.BAD_REQUEST);
            }

            StorageLocation storage = StorageLocation.getInstance();
            Location newLocation = new Location(airportId, airportName.trim(), airportCity.trim(), airportCountry.trim(), roundedLatitude, roundedLongitude);

            if (!storage.addLocation(newLocation)) {
                return new Response("Un aeropuerto con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Aeropuerto (Ubicación) creado exitosamente.", Status.CREATED, new Location(newLocation));
        } catch (Exception ex) {
            return new Response("Error inesperado al crear la ubicación: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getLocationById(String airportId) {
        if (!isValidAirportIdFormat(airportId)) {
            return new Response("El ID del aeropuerto debe ser 3 letras mayúsculas.", Status.BAD_REQUEST);
        }
        StorageLocation storage = StorageLocation.getInstance();
        Location location = storage.getLocation(airportId);
        if (location == null) {
            return new Response("Aeropuerto (Ubicación) no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Aeropuerto (Ubicación) recuperado exitosamente.", Status.OK, location);
    }

    public static Response getAllLocations() {
        try {
            StorageLocation storage = StorageLocation.getInstance();
            List<Location> locations = storage.getAllLocations();
            return new Response("Aeropuertos (Ubicaciones) recuperados exitosamente.", Status.OK, locations);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar ubicaciones: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static void ControllerChargeIds(AirportFrame vista) {
        StorageLocation storage = StorageLocation.getInstance();
        List<String> ids = storage.getAllIdLocations();
        vista.chargeLocationIds(ids);
    }
}
