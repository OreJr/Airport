/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Location;
import core.models.storage.ILocationStorage;
import core.models.storage.StorageLocation;

/**
 *
 * @author OreJr
 */
public class ExistInstanceLocationController implements ExistInstanceInterface<Location,String> {

    @Override
    public Location obtain(String LocationId) {
        ILocationStorage locationStorage = StorageLocation.getInstance();
        Location originalDepartureLocation = (Location) locationStorage.get(LocationId);
        return originalDepartureLocation;
    }
}
