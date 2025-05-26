/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.controllers.flightController.AddInterface;
import core.models.Plane;
import core.models.storage.StoragePlane;

/**
 *
 * @author OreJr
 */
public class AddPlaneController implements AddInterface<Plane> {

    @Override
    public boolean add(Plane newPlane) {
        StoragePlane storage = StoragePlane.getInstance();
        return storage.addPlane(newPlane);
    }

}
