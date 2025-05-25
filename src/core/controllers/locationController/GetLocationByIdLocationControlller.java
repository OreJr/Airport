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

//esto no se usa?

public class GetLocationByIdLocationControlller {
    public static Response getLocationById(String airportId) {
        if (!ValidAirportIdFormatLocationController.isValidAirportIdFormat(airportId)) {
            return new Response("El ID del aeropuerto debe ser 3 letras mayúsculas.", Status.BAD_REQUEST);
        }
        StorageLocation storage = StorageLocation.getInstance();
        Location location = storage.getLocation(airportId);
        if (location == null) {
            return new Response("Aeropuerto (Ubicación) no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Aeropuerto (Ubicación) recuperado exitosamente.", Status.OK, location);
    }
}
