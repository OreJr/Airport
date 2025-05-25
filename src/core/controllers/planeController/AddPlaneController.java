/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.models.Plane;
import core.models.storage.StoragePlane;

/**
 *
 * @author OreJr
 */
public class AddPlaneController {
    public static boolean add(Plane newPlane) {
        StoragePlane storage = StoragePlane.getInstance();
        return storage.addPlane(newPlane);
    }
}
