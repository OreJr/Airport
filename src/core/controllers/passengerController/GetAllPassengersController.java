/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.IPassenger;
import core.models.Passenger;
import core.models.storage.IPassengerStorage;
import core.models.storage.StoragePassenger;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class GetAllPassengersController {
    public static Response getAllPassengers() {
        try {
            IPassengerStorage storage = StoragePassenger.getInstance();
            List<IPassenger> passengers = storage.getAll();
            return new Response("Pasajeros recuperados exitosamente.", Status.OK, passengers);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar pasajeros: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
