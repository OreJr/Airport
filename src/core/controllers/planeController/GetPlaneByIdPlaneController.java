/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.StoragePlane;

/**
 *
 * @author OreJr
 */

//no se usa?
public class GetPlaneByIdPlaneController {
    public static Response getPlaneById(String id) {
        if (!ValidPlaneIdFormatController.isValidPlaneIdFormat(id)) {
            return new Response("El ID del avión debe seguir el formato XXYYYYY.", Status.BAD_REQUEST);
        }
        StoragePlane storage = StoragePlane.getInstance();
        Plane plane = storage.getPlane(id); 
        if (plane == null) {
            return new Response("Avión no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Avión recuperado exitosamente.", Status.OK, plane);
    }
}
