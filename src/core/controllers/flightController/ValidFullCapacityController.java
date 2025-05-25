/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;

/**
 *
 * @author OreJr
 */
public class ValidFullCapacityController {

    public static boolean isFullFlight(Flight originalFlight) {
        if (originalFlight.getNumPassengers() >= originalFlight.getPlane().getMaxCapacity()) {
            return true;
        }
        return false;
    }
}
