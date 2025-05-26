/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.models.Plane;
import core.models.storage.IPlaneStorage;
import core.models.storage.StoragePlane;

/**
 *
 * @author OreJr
 */
public class ExistInstancePlaneController implements ExistInstanceInterface<Plane, String> {

    @Override
    public Plane obtain(String planeId) {
        IPlaneStorage planeStorage = StoragePlane.getInstance();
        Plane originalPlane = (Plane) planeStorage.get(planeId);
        return originalPlane;
    }
}
