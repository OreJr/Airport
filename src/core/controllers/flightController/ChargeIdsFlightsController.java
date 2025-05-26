/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.storage.IFlightStorage;
import core.models.storage.StorageFlight;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class ChargeIdsFlightsController implements ChargeIdsInterface {

    @Override
    public void ControllerChargeIds(AirportFrame vista) {
        IFlightStorage storage = StorageFlight.getInstance();
        List<String> ids = storage.getAllEntityIds();
        vista.chargeFlightIds(ids);
    }
}
