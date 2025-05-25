/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Passenger;
import core.models.storage.StoragePassenger;

/**
 *
 * @author OreJr
 */
public class ExistInstancePassengerController {

    public  static Passenger obtainPassenger(long longPassengerId) {
        StoragePassenger passengerStorage = StoragePassenger.getInstance();
        Passenger originalPassenger = passengerStorage.getOriginalPassenger(longPassengerId);
        return originalPassenger;
    }
}
