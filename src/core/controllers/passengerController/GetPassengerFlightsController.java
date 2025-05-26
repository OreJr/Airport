/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.IFlight;
import core.models.Passenger;
import core.models.storage.IPassengerStorage;
import core.models.storage.StoragePassenger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class GetPassengerFlightsController {
    public static Response getPassengerFlights(String passengerIdParam) { 
        try {
            long longPassengerId;
            try {
                longPassengerId = Long.parseLong(passengerIdParam);
                if (longPassengerId < 0) {
                    return new Response("El ID del pasajero debe ser no negativo.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
            }
            IPassengerStorage storagePassenger = StoragePassenger.getInstance();
            Passenger passenger = (Passenger) storagePassenger.get(longPassengerId);

            if (passenger == null) {
                return new Response("Pasajero no encontrado.", Status.NOT_FOUND);
            }

            List<IFlight> flights = passenger.getFlights(); 
            Collections.sort(flights, Comparator.comparing(IFlight::getDepartureDate));
            
            return new Response("Vuelos del pasajero recuperados exitosamente.", Status.OK, flights);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar los vuelos del pasajero: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
