/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.StorageLocation;

/**
 *
 * @author OreJr
 */
public class CreateLocationController {
    public static Response createLocation(String airportId, String airportName, String airportCity, String airportCountry, String airportLatitude, String airportLongitude) {
        try {
            if (!ValidAirportIdFormatLocationController.isValidAirportIdFormat(airportId)) {
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
                if (!ValidLatitudeLocationController.isValidLatitude(doubleAirportLatitude)) {
                    return new Response("La latitud debe estar entre -90 y 90.", Status.BAD_REQUEST);
                }
                if (CountDecimalPlacesLocationController.countDecimalPlaces(doubleAirportLatitude) > 4) {
                    return new Response("La latitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLatitude = RoundToFourDecimalsLocationController.roundToFourDecimals(doubleAirportLatitude);
            } catch (NumberFormatException ex) {
                return new Response("La latitud debe ser numérica.", Status.BAD_REQUEST);
            }
            double doubleAirportLongitude;
            double roundedLongitude;
            try {
                doubleAirportLongitude = Double.parseDouble(airportLongitude);
                if (!ValidLongitudeLocationController.isValidLongitude(doubleAirportLongitude)) {
                    return new Response("La longitud debe estar entre -180 y 180.", Status.BAD_REQUEST);
                }
                if (CountDecimalPlacesLocationController.countDecimalPlaces(doubleAirportLongitude) > 4) {
                    return new Response("La longitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLongitude = RoundToFourDecimalsLocationController.roundToFourDecimals(doubleAirportLongitude);
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
}
