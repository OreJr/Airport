/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.FlightController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.models.storage.StorageFlight;
import core.models.storage.StorageLocation;
import core.models.storage.StoragePlane;
import java.time.DateTimeException;
import java.time.LocalDate; // Importado para obtener el año actual
import java.time.LocalDateTime;

/**
 *
 * @author OreJr
 */
public class CreateFlightController {
    public static Response createFlight(String id, String planeId,
            String departureLocationId, String arrivalLocationId, String scaleLocationId,
            String year, String month, String day, String hour, String minute,
            String hoursDurationArrival, String minutesDurationArrival,
            String hoursDurationScale, String minutesDurationScale) {
        try {
            if (!IsValidFlightIdFormatController.isValidFlightIdFormat(id)) {
                return new Response("El ID del vuelo debe seguir el formato XXXYYY (ej. ABC123).", Status.BAD_REQUEST);
            }

            StoragePlane planeStorage = StoragePlane.getInstance();
            Plane originalPlane = planeStorage.getOriginalPlane(planeId);
            if (originalPlane == null) {
                return new Response("Avión con ID " + planeId + " no encontrado.", Status.BAD_REQUEST);
            }

            StorageLocation locationStorage = StorageLocation.getInstance();
            Location originalDepartureLocation = locationStorage.getOriginalLocation(departureLocationId);
            if (originalDepartureLocation == null) {
                return new Response("Ubicación de salida " + departureLocationId + " no encontrada.", Status.BAD_REQUEST);
            }
            Location originalArrivalLocation = locationStorage.getOriginalLocation(arrivalLocationId);
            if (originalArrivalLocation == null) {
                return new Response("Ubicación de llegada " + arrivalLocationId + " no encontrada.", Status.BAD_REQUEST);
            }

            Location originalScaleLocation = null;
            if (scaleLocationId != null && !scaleLocationId.trim().isEmpty()
                    && !scaleLocationId.equalsIgnoreCase("Location") && !scaleLocationId.equalsIgnoreCase("None")) {
                originalScaleLocation = locationStorage.getOriginalLocation(scaleLocationId);
                if (originalScaleLocation == null) {
                    return new Response("Ubicación de escala " + scaleLocationId + " no encontrada.", Status.BAD_REQUEST);
                }
            }

            LocalDateTime departureDateTime;
            int intYear, intMonth, intDay, intHour, intMinute;
            try {
                intYear = Integer.parseInt(year);
                intMonth = Integer.parseInt(month);
                intDay = Integer.parseInt(day);
                intHour = Integer.parseInt(hour);
                intMinute = Integer.parseInt(minute);

                // --- INICIO DE NUEVA VALIDACIÓN DE AÑO DEL VUELO ---
                int currentYear = LocalDate.now().getYear();
                if (intYear < currentYear) {
                    return new Response("El año del vuelo no puede ser anterior al año actual (" + currentYear + ").", Status.BAD_REQUEST);
                }
                // --- FIN DE NUEVA VALIDACIÓN DE AÑO DEL VUELO ---

                try {
                    departureDateTime = LocalDateTime.of(intYear, intMonth, intDay, intHour, intMinute);
                } catch (DateTimeException e) {
                    return new Response("Fecha/hora de salida inválida.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Componentes de fecha/hora de salida deben ser numéricos.", Status.BAD_REQUEST);
            }

            int intHoursDurationArrival, intMinutesDurationArrival;
            try {
                intHoursDurationArrival = Integer.parseInt(hoursDurationArrival);
                intMinutesDurationArrival = Integer.parseInt(minutesDurationArrival);
                if (intHoursDurationArrival < 0 || intMinutesDurationArrival < 0 || (intHoursDurationArrival == 0 && intMinutesDurationArrival == 0)) {
                    return new Response("La duración de llegada debe ser > 00:00.", Status.BAD_REQUEST);
                }
                if (intMinutesDurationArrival >= 60) {
                    return new Response("Los minutos de duración de llegada deben ser < 60.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("La duración de llegada debe ser numérica.", Status.BAD_REQUEST);
            }

            int intHoursDurationScale = 0;
            int intMinutesDurationScale = 0;
            if (originalScaleLocation != null) {
                try {
                    intHoursDurationScale = Integer.parseInt(hoursDurationScale);
                    intMinutesDurationScale = Integer.parseInt(minutesDurationScale);
                    if (intHoursDurationScale < 0 || intMinutesDurationScale < 0 || (intHoursDurationScale == 0 && intMinutesDurationScale == 0)) {
                        return new Response("La duración de escala debe ser > 00:00 si se provee ubicación de escala.", Status.BAD_REQUEST);
                    }
                    if (intMinutesDurationScale >= 60) {
                        return new Response("Los minutos de duración de escala deben ser < 60.", Status.BAD_REQUEST);
                    }
                } catch (NumberFormatException ex) {
                    return new Response("La duración de escala debe ser numérica.", Status.BAD_REQUEST);
                }
            } else {
                boolean scaleHoursProvided = hoursDurationScale != null && !hoursDurationScale.trim().isEmpty();
                boolean scaleMinutesProvided = minutesDurationScale != null && !minutesDurationScale.trim().isEmpty();

                if (scaleHoursProvided) {
                    try {
                        intHoursDurationScale = Integer.parseInt(hoursDurationScale.trim());
                    } catch (NumberFormatException e) {
                        return new Response("Horas de duración de escala deben ser numéricas o vacías.", Status.BAD_REQUEST);
                    }
                }
                if (scaleMinutesProvided) {
                    try {
                        intMinutesDurationScale = Integer.parseInt(minutesDurationScale.trim());
                    } catch (NumberFormatException e) {
                        return new Response("Minutos de duración de escala deben ser numéricos o vacíos.", Status.BAD_REQUEST);
                    }
                }

                if (intHoursDurationScale != 0 || intMinutesDurationScale != 0) {
                    return new Response("La duración de escala debe ser 00:00 si no hay ubicación de escala.", Status.BAD_REQUEST);
                }
            }

            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight newFlight;
            if (originalScaleLocation != null) {
                newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalScaleLocation, originalArrivalLocation,
                        departureDateTime, intHoursDurationArrival, intMinutesDurationArrival,
                        intHoursDurationScale, intMinutesDurationScale);
            } else {
                newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalArrivalLocation,
                        departureDateTime, intHoursDurationArrival, intMinutesDurationArrival);
            }

            if (!flightStorage.addFlight(newFlight)) {
                return new Response("Un vuelo con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Vuelo creado exitosamente.", Status.CREATED, new Flight(newFlight));
        } catch (Exception ex) {
            return new Response("Error inesperado al crear el vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
