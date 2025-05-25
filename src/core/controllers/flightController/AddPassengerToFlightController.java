/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;


import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.storage.StorageFlight;
import core.models.storage.StoragePassenger;

/**
 *
 * @author OreJr
 */
public class AddPassengerToFlightController {
    public static Response addPassengerToFlight(String flightId, String passengerIdParam) {
        try {
            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight originalFlight = flightStorage.getOriginalFlight(flightId);
            if (originalFlight == null) {
                if (!ValidFlightIdFormatController.isValidFlightIdFormat(flightId)) {
                    return new Response("Formato de ID de vuelo inválido.", Status.BAD_REQUEST);
                }
                return new Response("Vuelo no encontrado.", Status.NOT_FOUND);
            }

            long longPassengerId;
            try {
                longPassengerId = Long.parseLong(passengerIdParam);
            } catch (NumberFormatException e) {
                return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
            }

            StoragePassenger passengerStorage = StoragePassenger.getInstance();
            Passenger originalPassenger = passengerStorage.getOriginalPassenger(longPassengerId);
            if (originalPassenger == null) {
                return new Response("Pasajero no encontrado.", Status.NOT_FOUND);
            }

            if (originalFlight.getNumPassengers() >= originalFlight.getPlane().getMaxCapacity()) {
                return new Response("El vuelo está en su capacidad máxima.", Status.BAD_REQUEST);
            }

            for (Passenger p : originalFlight.getPassengers()) {
                if (p.getId() == longPassengerId) {
                    return new Response("El pasajero ya está en este vuelo.", Status.BAD_REQUEST);
                }
            }

            originalFlight.addPassenger(new Passenger(originalPassenger));
            originalPassenger.addFlight(originalFlight);

            return new Response("Pasajero añadido al vuelo exitosamente.", Status.OK, new Flight(originalFlight));
        } catch (Exception ex) {
            return new Response("Error inesperado al añadir pasajero al vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
