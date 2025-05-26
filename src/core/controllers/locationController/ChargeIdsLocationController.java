/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.controllers.flightController.ChargeIdsInterface;
import core.models.storage.ILocationStorage;
import core.models.storage.StorageLocation;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsLocationController implements ChargeIdsInterface {

    @Override
    public void ControllerChargeIds(AirportFrame vista) {
        ILocationStorage storage = StorageLocation.getInstance();
        List<String> ids = storage.getAllEntityIds();
        vista.chargeLocationIds(ids);
    }

}
