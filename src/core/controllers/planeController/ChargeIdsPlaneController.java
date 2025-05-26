/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.controllers.flightController.ChargeIdsInterface;
import core.models.storage.StoragePlane;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsPlaneController implements ChargeIdsInterface {

    @Override
    public void ControllerChargeIds(AirportFrame vista) {
        StoragePlane storage = StoragePlane.getInstance();
        List<String> ids = storage.getAllIdPlanes();
        vista.chargePlaneIds(ids);
    }
}
