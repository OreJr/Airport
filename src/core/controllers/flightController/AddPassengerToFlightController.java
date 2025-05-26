/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;
import core.models.Passenger;

/**
 *
 * @author OreJr
 */
public class AddPassengerToFlightController {

    public static Boolean addPassengerController(Flight originalFlight, Passenger originalPassenger) {
        try {
            originalFlight.addPassenger(originalPassenger);
            originalPassenger.addFlight(originalFlight);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
