/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.StoragePlane;
import core.views.AirportFrame;
import java.util.List;

/**
 *
 * @author JorgeDuarte 
 */
public class PlaneController {

    private static boolean isValidPlaneIdFormat(String id) {
        if (id == null || id.length() != 7) { 
            return false;
        }
        for (int i = 0; i < 2; i++) { 
            char c = id.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        for (int i = 2; i < 7; i++) { 
            char c = id.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static Response createPlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            if (!isValidPlaneIdFormat(id)) {
                return new Response("El ID del avión debe seguir el formato XXYYYYY (ej. AB12345).", Status.BAD_REQUEST);
            }
            if (brand == null || brand.trim().isEmpty()) {
                return new Response("La marca no debe estar vacía.", Status.BAD_REQUEST);
            }
            if (model == null || model.trim().isEmpty()) {
                return new Response("El modelo no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (airline == null || airline.trim().isEmpty()) {
                return new Response("La aerolínea no debe estar vacía.", Status.BAD_REQUEST);
            }
            
            int intMaxCapacity;
            try {
                intMaxCapacity = Integer.parseInt(maxCapacity);
                if (intMaxCapacity <= 0) {
                    return new Response("La capacidad máxima debe ser positiva.", Status.BAD_REQUEST);
                }
                // --- INICIO DE NUEVA VALIDACIÓN DE CAPACIDAD MÁXIMA ---
                if (intMaxCapacity > 1200) {
                    return new Response("La capacidad máxima del avión no puede exceder 1200 personas.", Status.BAD_REQUEST);
                }
                // --- FIN DE NUEVA VALIDACIÓN DE CAPACIDAD MÁXIMA ---
            } catch (NumberFormatException ex) {
                return new Response("La capacidad máxima debe ser numérica.", Status.BAD_REQUEST);
            }

            StoragePlane storage = StoragePlane.getInstance();
            Plane newPlane = new Plane(id, brand.trim(), model.trim(), intMaxCapacity, airline.trim());

            if (!storage.addPlane(newPlane)) {
                return new Response("Un avión con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Avión creado exitosamente.", Status.CREATED, new Plane(newPlane));
        } catch (Exception ex) {
            return new Response("Error inesperado al crear el avión: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getPlaneById(String id) {
        if (!isValidPlaneIdFormat(id)) {
            return new Response("El ID del avión debe seguir el formato XXYYYYY.", Status.BAD_REQUEST);
        }
        StoragePlane storage = StoragePlane.getInstance();
        Plane plane = storage.getPlane(id); 
        if (plane == null) {
            return new Response("Avión no encontrado.", Status.NOT_FOUND);
        }
        return new Response("Avión recuperado exitosamente.", Status.OK, plane);
    }

    public static Response getAllPlanes() {
        try {
            StoragePlane storage = StoragePlane.getInstance();
            List<Plane> planes = storage.getAllPlanes(); 
            return new Response("Aviones recuperados exitosamente.", Status.OK, planes);
        } catch (Exception ex) {
            return new Response("Error inesperado al recuperar aviones: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static void ControllerChargeIds(AirportFrame vista) {
        StoragePlane storage = StoragePlane.getInstance();
            List<String > ids = storage.getAllIdPlanes();
            vista.chargePlaneIds(ids);
    }
}