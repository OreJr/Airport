/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

import core.controllers.flightController.NumericIntController;
import core.controllers.flightController.ValidStringNotEmpty;
import core.controllers.passengerController.ValidNumberAndCapacityController;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
/**
 *
 * @author OreJr
 */
public class CreatePlaneControllerResponse {

    public static Response createPlane(String id, String brand, String model, String maxCapacity, String airline) {
        try {
            if (!ValidPlaneIdFormatController.isValidPlaneIdFormat(id)) {
                return new Response("El ID del avión debe seguir el formato XXYYYYY (ej. AB12345).", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(brand.trim())) {
                return new Response("La marca no debe estar vacía.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(model.trim())) {
                return new Response("El modelo no debe estar vacío.", Status.BAD_REQUEST);
            }
            if (ValidStringNotEmpty.isValid(airline.trim())) {
                return new Response("La aerolínea no debe estar vacía.", Status.BAD_REQUEST);
            }

            int intMaxCapacity;

            intMaxCapacity = NumericIntController.isValidNumeric(maxCapacity);
            if (intMaxCapacity == -1) {
                return new Response("La capacidad máxima debe ser numérica.", Status.BAD_REQUEST);
            } else {
                if (!ValidNumberAndCapacityController.isValidNumber(intMaxCapacity, 1200)) {
                    return new Response("La capacidad máxima debe ser positiva y menor a 1200 personas", Status.BAD_REQUEST);
                }

            }

            
            Plane newPlane = CreatePlaneController.createPlane(id, brand.trim(), model.trim(), intMaxCapacity, airline.trim());

            if (!AddPlaneController.add(newPlane)) {
                return new Response("Un avión con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Avión creado exitosamente.", Status.CREATED, new Plane(newPlane));
        } catch (Exception ex) {
            return new Response("Error inesperado al crear el avión: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
