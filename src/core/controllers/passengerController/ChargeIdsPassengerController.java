/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.controllers.flightController.ChargeIdsInterface;
import core.models.storage.StoragePassenger;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsPassengerController implements ChargeIdsInterface {

    @Override
    public void ControllerChargeIds(AirportFrame vista) {
        StoragePassenger storage = StoragePassenger.getInstance();
        List<String> ids = storage.getAllIdPassengers();
        vista.chargePassengerIds(ids);
    }

}
