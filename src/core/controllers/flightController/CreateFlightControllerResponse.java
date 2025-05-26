/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import java.time.LocalDateTime;

/**
 *
 * @author OreJr
 */
public class CreateFlightControllerResponse {

    public static Response createFlight(String id, String planeId,
            String departureLocationId, String arrivalLocationId, String scaleLocationId,
            String year, String month, String day, String hour, String minute,
            String hoursDurationArrival, String minutesDurationArrival,
            String hoursDurationScale, String minutesDurationScale) {
        try {
            ExistInstanceInterface<Plane,String> existInstancePlaneController = new ExistInstancePlaneController();
            ExistInstanceInterface<Location,String> existInstanceLocationController = new ExistInstanceLocationController();
            AddInterface addFlightController = new AddFlightController();
            if (!ValidFlightIdFormatController.isValidFlightIdFormat(id)) {
                return new Response("El ID del vuelo debe seguir el formato XXXYYY (ej. ABC123).", Status.BAD_REQUEST);
            }

            Plane originalPlane = existInstancePlaneController.obtain(planeId);
            if (originalPlane == null) {
                return new Response("Avión con ID " + planeId + " no encontrado.", Status.BAD_REQUEST);
            }

            Location originalDepartureLocation = existInstanceLocationController.obtain(departureLocationId);
            if (originalDepartureLocation == null) {
                return new Response("Ubicación de salida " + departureLocationId + " no encontrada.", Status.BAD_REQUEST);
            }
            Location originalArrivalLocation = existInstanceLocationController.obtain(arrivalLocationId);
            if (originalArrivalLocation == null) {
                return new Response("Ubicación de llegada " + arrivalLocationId + " no encontrada.", Status.BAD_REQUEST);
            }

            Location originalScaleLocation = null;
            if (ExistScaleLocationController.ExistScaleLocation(scaleLocationId)) {
                originalScaleLocation = existInstanceLocationController.obtain(departureLocationId);
                if (originalScaleLocation == null) {
                    return new Response("Ubicación de escala " + scaleLocationId + " no encontrada.", Status.BAD_REQUEST);
                }
            }

            LocalDateTime departureDateTime;
            int intYear = NumericIntController.isValidNumeric(year),
                    intMonth = NumericIntController.isValidNumeric(month),
                    intDay = NumericIntController.isValidNumeric(day),
                    intHour = NumericIntController.isValidNumeric(hour),
                    intMinute = NumericIntController.isValidNumeric(minute);

            if (intYear == -1 || intMonth == -1 || intDay == -1 || intHour == -1 || intMinute == -1) {
                return new Response("Componentes de fecha/hora de salida deben ser numéricos.", Status.BAD_REQUEST);
            } else {
                if (!ValidDepartureYearController.isValidDepartureYear(intYear)) {
                    return new Response("El año del vuelo no puede ser anterior al año actual.", Status.BAD_REQUEST);
                }

                departureDateTime = ValidCreateLocalDateTimeController.isValidLocalDateTime(intYear, intMonth, intDay, intHour, intMinute);
                if (departureDateTime == null) {
                    return new Response("Fecha/hora de salida inválida.", Status.BAD_REQUEST);
                }
            }

            int intHoursDurationArrival = NumericIntController.isValidNumeric(hoursDurationArrival),
                    intMinutesDurationArrival = NumericIntController.isValidNumeric(minutesDurationArrival);

            if (intHoursDurationArrival == -1 || intMinutesDurationArrival == -1) {
                return new Response("La duración de llegada debe ser numérica.", Status.BAD_REQUEST);
            } else {
                if (!ValidMinutesAndHoursController.isValid(intHoursDurationArrival, intMinutesDurationArrival)) {
                    return new Response("La duración de llegada debe ser > 00:00.", Status.BAD_REQUEST);
                }
                if (!ValidMinutesController.isValid(intMinutesDurationArrival)) {
                    return new Response("Los minutos de duración de llegada deben ser < 60.", Status.BAD_REQUEST);
                }
            }

            int intHoursDurationScale = 0;
            int intMinutesDurationScale = 0;
            if (originalScaleLocation != null) {

                intHoursDurationScale = NumericIntController.isValidNumeric(hoursDurationScale);
                intMinutesDurationScale = NumericIntController.isValidNumeric(minutesDurationScale);
                if (intHoursDurationScale == -1 || intMinutesDurationScale == -1) {
                    return new Response("La duración de escala debe ser numérica.", Status.BAD_REQUEST);
                } else {
                    if (!ValidMinutesAndHoursController.isValid(intHoursDurationScale, intMinutesDurationScale)) {
                        return new Response("La duración de escala debe ser > 00:00 si se provee ubicación de escala.", Status.BAD_REQUEST);
                    }
                    if (!ValidMinutesController.isValid(intMinutesDurationScale)) {
                        return new Response("Los minutos de duración de escala deben ser < 60.", Status.BAD_REQUEST);
                    }
                }

            } else {
                boolean scaleHoursProvided = !ValidStringNotEmpty.isValid(hoursDurationScale);
                boolean scaleMinutesProvided = !ValidStringNotEmpty.isValid(minutesDurationScale);

                if (scaleHoursProvided) {
                    intHoursDurationScale = NumericIntController.isValidNumeric(hoursDurationScale.trim());
                    if (intHoursDurationScale == -1) {
                        return new Response("Horas de duración de escala deben ser numéricas o vacías.", Status.BAD_REQUEST);
                    }
                }
                if (scaleMinutesProvided) {
                    intMinutesDurationScale = NumericIntController.isValidNumeric(minutesDurationScale.trim());
                    if (intMinutesDurationScale == -1) {
                        return new Response("Minutos de duración de escala deben ser numéricos o vacíos.", Status.BAD_REQUEST);
                    }
                }

                if (intHoursDurationScale != 0 || intMinutesDurationScale != 0) {
                    return new Response("La duración de escala debe ser 00:00 si no hay ubicación de escala.", Status.BAD_REQUEST);
                }
            }

           
            Flight newFlight;
            if (originalScaleLocation != null) {
                newFlight = CreateFlightController.createFlight(id, originalPlane, originalDepartureLocation, originalScaleLocation, originalArrivalLocation,
                        departureDateTime, intHoursDurationArrival, intMinutesDurationArrival,
                        intHoursDurationScale, intMinutesDurationScale);
            } else {
                newFlight = CreateFlightController.createFlight(id, originalPlane, originalDepartureLocation, originalArrivalLocation,
                        departureDateTime, intHoursDurationArrival, intMinutesDurationArrival);
            }

            if (!addFlightController.add(newFlight)) {
                return new Response("Un vuelo con ese ID ya existe.", Status.BAD_REQUEST);
            }
            return new Response("Vuelo creado exitosamente.", Status.CREATED, newFlight);
        } catch (Exception ex) {
            return new Response("Error inesperado al crear el vuelo: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
