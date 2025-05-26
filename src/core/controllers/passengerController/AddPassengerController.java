/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.flightController.AddInterface;
import core.models.Passenger;
import core.models.storage.StoragePassenger;

/**
 *
 * @author OreJr
 */
public class AddPassengerController implements AddInterface<Passenger> {

    @Override
    public boolean add(Passenger newPassenger) {
        StoragePassenger storage = StoragePassenger.getInstance();
        return storage.addPassenger(newPassenger);
    }

}
