/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.storage.StorageFlight;

/**
 *
 * @author OreJr
 */
public class GetFlightByIdController {
    public static Response getFlightById(String flightId) {
        if (!ValidFlightIdFormatController.isValidFlightIdFormat(flightId)) {
            return new Response("El ID del vuelo debe seguir el formato XXXYYY.", Status.BAD_REQUEST);
        }
        StorageFlight storage = StorageFlight.getInstance();
        Flight flightCopy = storage.getFlightCopy(flightId);
        if (flightCopy == null) {
            return new Response("Vuelo no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Vuelo recuperado exitosamente.", Status.OK, flightCopy);
    }
}
