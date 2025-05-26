/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;
import core.models.storage.StorageFlight;

/**
 *
 * @author OreJr
 */
public class ExistInstanceFlightController implements ExistInstanceInterface<Flight, String> {

    @Override
    public Flight obtain(String flightId) {
        StorageFlight flightStorage = StorageFlight.getInstance();
        Flight originalFlight = flightStorage.getOriginalFlight(flightId);
        return originalFlight;
    }
}
