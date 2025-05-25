/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.models.storage.StorageLocation;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsLocationController {
    public static void ControllerChargeIds(AirportFrame vista) {
        StorageLocation storage = StorageLocation.getInstance();
        List<String> ids = storage.getAllIdLocations();
        vista.chargeLocationIds(ids);
    }
}
