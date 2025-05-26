/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.controllers.flightController.AddInterface;
import core.models.Location;
import core.models.storage.ILocationStorage;
import core.models.storage.StorageLocation;

/**
 *
 * @author OreJr
 */
public class AddLocationController implements AddInterface<Location> {

    @Override
    public boolean add(Location newLocation) {
        ILocationStorage storage = StorageLocation.getInstance();
        return storage.add(newLocation);
    }
}
