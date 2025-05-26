/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.controllers.flightController.AddFlightController;
import core.controllers.flightController.AddInterface;
import core.controllers.flightController.NumericDoubleController;
import core.controllers.flightController.ValidStringNotEmpty;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;

/**
 *
 * @author OreJr
 */
public class CreateLocationControllerResponse {

    public static Response createLocation(String airportId, String airportName, String airportCity, String airportCountry, String airportLatitude, String airportLongitude) {
        try {
            AddInterface addLocationController = new AddLocationController();
            if (!ValidAirportIdFormatLocationController.isValidAirportIdFormat(airportId)) {
                return new Response("El ID del aeropuerto debe ser 3 letras mayúsculas.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(airportName.trim())) {
                return new Response("El nombre del aeropuerto no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(airportCity.trim())) {
                return new Response("La ciudad del aeropuerto no debe estar vacía.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(airportCountry.trim())) {
                return new Response("El país del aeropuerto no debe estar vacío.", Status.BAD_REQUEST);
            }
            double doubleAirportLatitude;
            double roundedLatitude;

            doubleAirportLatitude = NumericDoubleController.isValidNumeric(airportLatitude);
            if (doubleAirportLatitude == -1) {
                return new Response("La latitud debe ser numérica.", Status.BAD_REQUEST);
            } else {
                if (!ValidLatitudeLocationController.isValidLatitude(doubleAirportLatitude)) {
                    return new Response("La latitud debe estar entre -90 y 90.", Status.BAD_REQUEST);
                }
                if (CountDecimalPlacesLocationController.countDecimalPlaces(doubleAirportLatitude) > 4) {
                    return new Response("La latitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLatitude = RoundToFourDecimalsLocationController.roundToFourDecimals(doubleAirportLatitude);
            }

            double doubleAirportLongitude;
            double roundedLongitude;

            doubleAirportLongitude = NumericDoubleController.isValidNumeric(airportLongitude);
            if (doubleAirportLongitude == -1) {
                return new Response("La longitud debe ser numérica.", Status.BAD_REQUEST);
            } else {
                if (!ValidLongitudeLocationController.isValidLongitude(doubleAirportLongitude)) {
                    return new Response("La longitud debe estar entre -180 y 180.", Status.BAD_REQUEST);
                }
                if (CountDecimalPlacesLocationController.countDecimalPlaces(doubleAirportLongitude) > 4) {
                    return new Response("La longitud debe tener como máximo 4 decimales.", Status.BAD_REQUEST);
                }
                roundedLongitude = RoundToFourDecimalsLocationController.roundToFourDecimals(doubleAirportLongitude);
            }

            Location newLocation = CreateLocationController.createLocation(airportId, airportName.trim(), airportCity.trim(), airportCountry.trim(), roundedLatitude, roundedLongitude);

            if (!addLocationController.add(newLocation)) {
                return new Response("Un aeropuerto con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Aeropuerto (Ubicación) creado exitosamente.", Status.CREATED, new Location(newLocation));
        } catch (Exception ex) {
            return new Response("Error inesperado al crear la ubicación: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
