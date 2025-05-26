/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;

/**
 *
 * @author OreJr
 */
public class AddPassengerToFlightControllerResponse {

    public static Response addPassengerToFlight(String flightId, String passengerIdParam) {
        try {
            ExistInstanceInterface<Flight,String> existInstanceFlightController = new ExistInstanceFlightController();
            ExistInstanceInterface<Passenger, Long> existInstancePassengerController = new ExistInstancePassengerController();
            
            Flight originalFlight = existInstanceFlightController.obtain(flightId);
            if (originalFlight == null) {
                if (!ValidFlightIdFormatController.isValidFlightIdFormat(flightId)) {
                    return new Response("Formato de ID de vuelo inválido.", Status.BAD_REQUEST);
                }
                return new Response("Vuelo no encontrado.", Status.NOT_FOUND);
            }

            long longPassengerId = NumericLongController.isValidNumeric(passengerIdParam);

            if (longPassengerId == -1) {
                return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
            }

            Passenger originalPassenger = existInstancePassengerController.obtain(longPassengerId);
            if (originalPassenger == null) {
                return new Response("Pasajero no encontrado.", Status.NOT_FOUND);
            }

            if (ValidFullCapacityController.isFullFlight(originalFlight)) {
                return new Response("El vuelo está en su capacidad máxima.", Status.BAD_REQUEST);
            }

            if (ValidPassengerInTheFlightController.isPassengerInTheFlight(originalFlight, longPassengerId)) {
                return new Response("El pasajero ya está en este vuelo.", Status.BAD_REQUEST);
            }

            originalFlight.addPassenger(originalPassenger);
            originalPassenger.addFlight(originalFlight);
            boolean isAddPassenger = AddPassengerToFlightController.addPassengerController(originalFlight, originalPassenger);
            if (isAddPassenger) {
                return new Response("Pasajero añadido al vuelo exitosamente.", Status.OK, originalFlight);

            } else {
                return new Response("Error inesperado al añadir pasajero al vuelo", Status.INTERNAL_SERVER_ERROR);

            }

        } catch (Exception ex) {
            return new Response("Error inesperado al añadir pasajero al vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);

        }
    }
}
