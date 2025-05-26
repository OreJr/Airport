/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;
import core.models.IPassenger;
import core.models.Passenger;

/**
 *
 * @author OreJr
 */
public class ValidPassengerInTheFlightController {

    public static boolean isPassengerInTheFlight(Flight originalFlight, long longPassengerId) {
        for (IPassenger p : originalFlight.getPassengers()) {
            if (p.getId() == longPassengerId) {
                return true;
            }
        }
        return false;
    }
}
