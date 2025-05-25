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
public class DelayFlightControllerResponse {

    public static Response delayFlight(String flightId, String hours, String minutes) {
        try {

            int intHours = NumericIntController.isValidNumeric(hours),
                    intMinutes = NumericIntController.isValidNumeric(minutes);

            if (intHours == -1 || intMinutes == -1) {
                return new Response("El tiempo de retraso debe ser numérico.", Status.BAD_REQUEST);
            } else {
                if (!ValidMinutesAndHoursController.isValid(intHours, intMinutes)) {
                    return new Response("El tiempo de retraso debe ser > 00:00.", Status.BAD_REQUEST);
                }
                if (!ValidMinutesController.isValid(intMinutes)) {
                    return new Response("Los minutos de retraso deben ser < 60.", Status.BAD_REQUEST);
                }
            }

            Flight originalFlight = ExistInstanceFlightController.obtainFlight(flightId);
            if (originalFlight == null) {
                if (!ValidFlightIdFormatController.isValidFlightIdFormat(flightId)) {
                    return new Response("Formato de ID de vuelo inválido para retraso.", Status.BAD_REQUEST);
                }
                return new Response("Vuelo no encontrado.", Status.NOT_FOUND);
            }
            Boolean delayFlightController = DelayFlightController.DelayFlight(originalFlight, intHours, intMinutes);
            if (delayFlightController) {
                return new Response("Vuelo retrasado exitosamente.", Status.OK, new Flight(originalFlight));
            } else {
                return new Response("Error inesperado al retrasar el vuelo", Status.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            return new Response("Error inesperado al retrasar el vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
