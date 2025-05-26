/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.IFlight;
import core.models.storage.IFlightStorage;
import core.models.storage.StorageFlight;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class GetAllFlightsController {
    public static Response getAllFlights() {
        try {
            IFlightStorage storage = StorageFlight.getInstance();
            List<IFlight> flights = storage.getAll();
            return new Response("Vuelos recuperados exitosamente.", Status.OK, flights);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar vuelos: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
