/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import core.models.storage.StorageFlight;
import core.models.storage.StorageLocation;
import core.models.storage.StoragePassenger;
import core.models.storage.StoragePlane;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author JorgeDuarte
 */
public class FlightController {

    /**
     * Valida el formato del ID de un vuelo (XXX000: 3 letras mayúsculas
     * seguidas de 3 dígitos).
     *
     * @param id El ID a validar.
     * @return true si el formato es válido, false en caso contrario.
     */
    private static boolean isValidFlightIdFormat(String id) {
        if (id == null || id.length() != 6) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char c = id.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        for (int i = 3; i < 6; i++) {
            char c = id.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static Response createFlight(String id, String planeId,
            String departureLocationId, String arrivalLocationId, String scaleLocationId,
            String year, String month, String day, String hour, String minute,
            String hoursDurationArrival, String minutesDurationArrival,
            String hoursDurationScale, String minutesDurationScale) {
        try {
            int intHoursDurationArrival, intMinutesDurationArrival, intHoursDurationScale, intMinutesDurationScale;
            if (!isValidFlightIdFormat(id)) {
                return new Response("Flight ID must follow format XXXYYY (e.g., ABC123).", Status.BAD_REQUEST);
            }

            StoragePlane planeStorage = StoragePlane.getInstance();
            Plane originalPlane = planeStorage.getOriginalPlane(planeId);
            if (originalPlane == null) {
                return new Response("Plane with ID " + planeId + " not found.", Status.BAD_REQUEST);
            }

            StorageLocation locationStorage = StorageLocation.getInstance();
            Location originalDepartureLocation = locationStorage.getOriginalLocation(departureLocationId);
            if (originalDepartureLocation == null) {
                return new Response("Departure location " + departureLocationId + " not found.", Status.BAD_REQUEST);
            }
            Location originalArrivalLocation = locationStorage.getOriginalLocation(arrivalLocationId);
            if (originalArrivalLocation == null) {
                return new Response("Arrival location " + arrivalLocationId + " not found.", Status.BAD_REQUEST);
            }

            Location originalScaleLocation = null;
            if (scaleLocationId != null && !scaleLocationId.trim().isEmpty()) {
                originalScaleLocation = locationStorage.getOriginalLocation(scaleLocationId);
                if (originalScaleLocation == null) {
                    return new Response("Scale location " + scaleLocationId + " not found.", Status.BAD_REQUEST);
                }
            }

            LocalDateTime departureDateTime;
            try {
                departureDateTime = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),
                        Integer.parseInt(hour), Integer.parseInt(minute));
            } catch (DateTimeException e) {
                return new Response("Invalid departure date/time.", Status.BAD_REQUEST);
            }

            try {
                intHoursDurationArrival = Integer.parseInt(hoursDurationArrival);
                intMinutesDurationArrival = Integer.parseInt(minutesDurationArrival);
                if (intHoursDurationArrival < 0 || intMinutesDurationArrival < 0 || (intHoursDurationArrival == 0 && intMinutesDurationArrival == 0)) {
                    return new Response("Arrival duration must be > 00:00.", Status.BAD_REQUEST);
                }

                if (intMinutesDurationArrival >= 60) {
                    return new Response("Arrival duration minutes must be < 60.", Status.BAD_REQUEST);
                }

            } catch (NumberFormatException ex) {
                return new Response("arrival duration must be numeric", Status.BAD_REQUEST);
            }

            try {
                intHoursDurationScale = Integer.parseInt(hoursDurationScale);
                intMinutesDurationScale = Integer.parseInt(minutesDurationScale);
                if (originalScaleLocation != null) {
                    if (intHoursDurationScale < 0 || intMinutesDurationScale < 0 || (intHoursDurationScale == 0 && intMinutesDurationScale == 0)) {
                        return new Response("Scale duration must be > 00:00 if scale location provided.", Status.BAD_REQUEST);
                    }
                    if (intMinutesDurationScale >= 60) {
                        return new Response("Scale duration minutes must be < 60.", Status.BAD_REQUEST);
                    }
                } else {
                    if (intHoursDurationScale != 0 || intMinutesDurationScale != 0) {
                        return new Response("Scale duration must be 00:00 if no scale location.", Status.BAD_REQUEST);
                    }
                }
            } catch (NumberFormatException ex) {
                return new Response("Scale duration must be numeric", Status.BAD_REQUEST);
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
                return new Response("A flight with that ID already exists.", Status.BAD_REQUEST);
            }
            return new Response("Flight created successfully.", Status.CREATED, new Flight(newFlight));
        } catch (Exception ex) {
            return new Response("Unexpected error creating flight: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response addPassengerToFlight(String flightId, String passengerId) {
        try {
            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight originalFlight = flightStorage.getOriginalFlight(flightId);
            if (originalFlight == null) {
                if (!isValidFlightIdFormat(flightId)) { // Chequeo de formato adicional
                    return new Response("Invalid Flight ID format.", Status.BAD_REQUEST);
                }
                return new Response("Flight not found.", Status.NOT_FOUND);
            }

            StoragePassenger passengerStorage = StoragePassenger.getInstance();
            Passenger originalPassenger;
            long longPassengerId;
            try {
                longPassengerId = Long.parseLong(passengerId);
                originalPassenger = passengerStorage.getOriginalPassenger(longPassengerId);
            } catch (NumberFormatException ex) {
                return new Response("Passenger Id must be numeric", Status.BAD_REQUEST);
            }

            if (originalPassenger == null) {
                return new Response("Passenger not found.", Status.NOT_FOUND);
            }

            if (originalFlight.getNumPassengers() >= originalFlight.getPlane().getMaxCapacity()) {
                return new Response("Flight is at maximum capacity.", Status.BAD_REQUEST);
            }

            for (Passenger p : originalFlight.getPassengers()) {
                if (p.getId() == longPassengerId) {
                    return new Response("Passenger already on this flight.", Status.BAD_REQUEST);
                }
            }

            originalFlight.addPassenger(new Passenger(originalPassenger));
            originalPassenger.addFlight(originalFlight);

            return new Response("Passenger added to flight successfully.", Status.OK, new Flight(originalFlight));
        } catch (Exception ex) {
            return new Response("Unexpected error adding passenger to flight: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response delayFlight(String flightId, String hours, String minutes) {
        try {
            int intHours, intMinutes;
            try {
                intHours = Integer.parseInt(hours);
                intMinutes = Integer.parseInt(minutes);
                if (intHours < 0 || intMinutes < 0 || (intHours == 0 && intMinutes == 0)) {
                    return new Response("Delay time must be > 00:00.", Status.BAD_REQUEST);
                }
                if (intMinutes >= 60) {
                    return new Response("Delay minutes must be < 60.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Delay time must be numeric", Status.BAD_REQUEST);
            }

            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight originalFlight = flightStorage.getOriginalFlight(flightId);
            if (originalFlight == null) {
                if (!isValidFlightIdFormat(flightId)) {
                    return new Response("Invalid Flight ID format for delay.", Status.BAD_REQUEST);
                }
                return new Response("Flight not found.", Status.NOT_FOUND);
            }

            originalFlight.delay(intHours, intMinutes);
            return new Response("Flight delayed successfully.", Status.OK, new Flight(originalFlight));
        } catch (Exception ex) {
            return new Response("Unexpected error delaying flight: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getFlightById(String flightId) {
        if (!isValidFlightIdFormat(flightId)) {
            return new Response("Flight ID must follow format XXXYYY.", Status.BAD_REQUEST);
        }
        StorageFlight storage = StorageFlight.getInstance();
        Flight flightCopy = storage.getFlightCopy(flightId);
        if (flightCopy == null) {
            return new Response("Flight not found.", Status.NOT_FOUND);
        }
        return new Response("Flight retrieved successfully.", Status.OK, flightCopy);
    }

    public static Response getAllFlights() {
        try {
            StorageFlight storage = StorageFlight.getInstance();
            List<Flight> flights = storage.getAllFlights();
            return new Response("Flights retrieved successfully.", Status.OK, flights);
        } catch (Exception ex) {
            return new Response("Unexpected error retrieving flights: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
