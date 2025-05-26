/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.locationController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.ILocation;
import core.models.Location;
import core.models.storage.ILocationStorage;
import core.models.storage.StorageLocation;
import java.util.List;

/**
 *
 * @author OreJr
 */
public class GetAllLocationsController {
    public static Response getAllLocations() {
        try {
            ILocationStorage storage = StorageLocation.getInstance();
            List<ILocation> locations = storage.getAll();
            return new Response("Aeropuertos (Ubicaciones) recuperados exitosamente.", Status.OK, locations);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar ubicaciones: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
