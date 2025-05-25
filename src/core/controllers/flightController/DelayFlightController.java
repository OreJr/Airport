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
public class DelayFlightController {
    public static Response delayFlight(String flightId, String hours, String minutes) {
        try {
            int intHours, intMinutes;
            try {
                intHours = Integer.parseInt(hours);
                intMinutes = Integer.parseInt(minutes);
                if (intHours < 0 || intMinutes < 0 || (intHours == 0 && intMinutes == 0)) {
                    return new Response("El tiempo de retraso debe ser > 00:00.", Status.BAD_REQUEST);
                }
                if (intMinutes >= 60) {
                    return new Response("Los minutos de retraso deben ser < 60.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("El tiempo de retraso debe ser numérico.", Status.BAD_REQUEST);
            }

            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight originalFlight = flightStorage.getOriginalFlight(flightId);
            if (originalFlight == null) {
                if (!ValidFlightIdFormatController.isValidFlightIdFormat(flightId)) {
                    return new Response("Formato de ID de vuelo inválido para retraso.", Status.BAD_REQUEST);
                }
                return new Response("Vuelo no encontrado.", Status.NOT_FOUND);
            }

            originalFlight.delay(intHours, intMinutes);
            return new Response("Vuelo retrasado exitosamente.", Status.OK, new Flight(originalFlight));
        } catch (Exception ex) {
            return new Response("Error inesperado al retrasar el vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
