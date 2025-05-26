/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.IPlane;
import core.models.Plane;
import core.models.storage.IPlaneStorage;
import core.models.storage.StoragePlane;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class GetAllPlanesController {
    public static Response getAllPlanes() {
        try {
            IPlaneStorage  storage = StoragePlane.getInstance();
            List<IPlane> planes = storage.getAll(); 
            return new Response("Aviones recuperados exitosamente.", Status.OK, planes);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar aviones: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
