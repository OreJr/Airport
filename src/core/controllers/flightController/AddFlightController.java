/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Flight;
import core.models.storage.IFlightStorage;
import core.models.storage.StorageFlight;

/**
 *
 * @author OreJr
 */
public class AddFlightController implements AddInterface<Flight> {

    @Override
    public boolean add(Flight newFlight) {
        IFlightStorage flightStorage = StorageFlight.getInstance();
        return flightStorage.add(newFlight);
    }

}
