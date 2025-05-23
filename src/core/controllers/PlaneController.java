/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.StoragePlane; 
import java.util.List;

/**
 *
 * @author JorgeDuarte
 */
public class PlaneController {



    /**
     * Valida el formato del ID de un avión (XX00000: 2 letras mayúsculas seguidas de 5 dígitos).
     * @param id El ID a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
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
                return new Response("Plane ID must follow format XXYYYYY (e.g., AB12345).", Status.BAD_REQUEST);
            }
            if (brand == null || brand.trim().isEmpty()) {
                return new Response("Brand must not be empty.", Status.BAD_REQUEST);
            }
            if (model == null || model.trim().isEmpty()) {
                return new Response("Model must not be empty.", Status.BAD_REQUEST);
            }
            if (airline == null || airline.trim().isEmpty()) {
                return new Response("Airline must not be empty.", Status.BAD_REQUEST);
            }
            if (maxCapacity <= 0) {
                return new Response("Maximum capacity must be positive.", Status.BAD_REQUEST);
            }

            StoragePlane storage = StoragePlane.getInstance();
            Plane newPlane = new Plane(id, brand.trim(), model.trim(), maxCapacity, airline.trim());

            if (!storage.addPlane(newPlane)) {
                return new Response("A plane with that ID already exists.", Status.BAD_REQUEST);
            }
            return new Response("Plane created successfully.", Status.CREATED, new Plane(newPlane));
        } catch (Exception ex) {
            return new Response("Unexpected error creating plane: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getPlaneById(String id) {
        if (!isValidPlaneIdFormat(id)) {
            return new Response("Plane ID must follow format XXYYYYY.", Status.BAD_REQUEST);
        }
        StoragePlane storage = StoragePlane.getInstance();
        Plane plane = storage.getPlane(id); 
        if (plane == null) {
            return new Response("Plane not found.", Status.NOT_FOUND);
        }
        return new Response("Plane retrieved successfully.", Status.OK, plane);
    }

    public static Response getAllPlanes() {
        try {
            StoragePlane storage = StoragePlane.getInstance();
            List<Plane> planes = storage.getAllPlanes(); 
            return new Response("Planes retrieved successfully.", Status.OK, planes);
        } catch (Exception ex) {
            return new Response("Unexpected error retrieving planes: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}