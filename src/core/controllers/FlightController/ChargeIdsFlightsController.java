/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.FlightController;

import core.models.storage.StorageFlight;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsFlightsController {
     public static void ControllerChargeIds(AirportFrame vista) {
        StorageFlight storage = StorageFlight.getInstance();
        List<String> ids = storage.getAllIdFlights();
        vista.chargeFlightIds(ids);
    }
}
