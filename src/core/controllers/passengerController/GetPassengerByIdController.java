/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Passenger;
import core.models.storage.StoragePassenger;

/**
 *
 * @author OreJr
 */
public class GetPassengerByIdController {
    // no se usa?
    public static Response getPassengerById(String id) { 
        long longId;
        try {
            longId = Long.parseLong(id);
            if (longId < 0) {
                return new Response("El ID del pasajero debe ser no negativo.", Status.BAD_REQUEST);
            }
            if (String.valueOf(longId).length() > 15) {
                 return new Response("Formato de ID de pasajero inválido (máx 15 dígitos).", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException ex) {
            return new Response("El ID del pasajero debe ser numérico.", Status.BAD_REQUEST);
        }

        StoragePassenger storage = StoragePassenger.getInstance();
        Passenger passenger = storage.getPassenger(longId);
        if (passenger == null) {
            return new Response("Pasajero no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Pasajero recuperado exitosamente.", Status.OK, passenger);
    }
}
