/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Passenger;
import core.models.storage.IPassengerStorage;
import core.models.storage.StoragePassenger;

/**
 *
 * @author OreJr
 */
public class ExistInstancePassengerController implements ExistInstanceInterface<Passenger, Long> {

    @Override
    public Passenger obtain(Long longPassengerId) {
        IPassengerStorage passengerStorage = StoragePassenger.getInstance();
        Passenger originalPassenger = (Passenger) passengerStorage.get(longPassengerId);
        return originalPassenger;
    }
}
