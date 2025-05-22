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
     * Valida el formato del ID de un vuelo (XXX000: 3 letras mayúsculas seguidas de 3 dígitos).
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
                                        int year, int month, int day, int hour, int minute,
                                        int hoursDurationArrival, int minutesDurationArrival,
                                        int hoursDurationScale, int minutesDurationScale) {
        try {
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
                departureDateTime = LocalDateTime.of(year, month, day, hour, minute);
            } catch (DateTimeException e) {
                return new Response("Invalid departure date/time.", Status.BAD_REQUEST);
            }

            if (hoursDurationArrival < 0 || minutesDurationArrival < 0 || (hoursDurationArrival == 0 && minutesDurationArrival == 0)) {
                return new Response("Arrival duration must be > 00:00.", Status.BAD_REQUEST);
            }
            if (minutesDurationArrival >= 60) {
                return new Response("Arrival duration minutes must be < 60.", Status.BAD_REQUEST);
            }

            if (originalScaleLocation != null) {
                if (hoursDurationScale < 0 || minutesDurationScale < 0 || (hoursDurationScale == 0 && minutesDurationScale == 0)) {
                    return new Response("Scale duration must be > 00:00 if scale location provided.", Status.BAD_REQUEST);
                }
                if (minutesDurationScale >= 60) {
                    return new Response("Scale duration minutes must be < 60.", Status.BAD_REQUEST);
                }
            } else { 
                if (hoursDurationScale != 0 || minutesDurationScale != 0) {
                    return new Response("Scale duration must be 00:00 if no scale location.", Status.BAD_REQUEST);
                }
            }
            
            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight newFlight;
            if (originalScaleLocation != null) {
                newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalScaleLocation, originalArrivalLocation,
                                       departureDateTime, hoursDurationArrival, minutesDurationArrival,
                                       hoursDurationScale, minutesDurationScale);
            } else {
                newFlight = new Flight(id, originalPlane, originalDepartureLocation, originalArrivalLocation,
                                       departureDateTime, hoursDurationArrival, minutesDurationArrival);
            }

            if (!flightStorage.addFlight(newFlight)) {
                return new Response("A flight with that ID already exists.", Status.BAD_REQUEST);
            }
            return new Response("Flight created successfully.", Status.CREATED, new Flight(newFlight));
        } catch (Exception ex) {
            return new Response("Unexpected error creating flight: " + ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response addPassengerToFlight(String flightId, long passengerId) {
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
            Passenger originalPassenger = passengerStorage.getOriginalPassenger(passengerId); 
            if (originalPassenger == null) {
                return new Response("Passenger not found.", Status.NOT_FOUND);
            }

            if (originalFlight.getNumPassengers() >= originalFlight.getPlane().getMaxCapacity()) {
                return new Response("Flight is at maximum capacity.", Status.BAD_REQUEST);
            }
            
            for(Passenger p : originalFlight.getPassengers()){ 
                if(p.getId() == passengerId) {
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

    public static Response delayFlight(String flightId, int hours, int minutes) {
        try {
            if (hours < 0 || minutes < 0 || (hours == 0 && minutes == 0)) {
                return new Response("Delay time must be > 00:00.", Status.BAD_REQUEST);
            }
            if (minutes >= 60) {
                return new Response("Delay minutes must be < 60.", Status.BAD_REQUEST);
            }

            StorageFlight flightStorage = StorageFlight.getInstance();
            Flight originalFlight = flightStorage.getOriginalFlight(flightId); 
             if (originalFlight == null) {
                if (!isValidFlightIdFormat(flightId)) { 
                     return new Response("Invalid Flight ID format for delay.", Status.BAD_REQUEST);
                }
                return new Response("Flight not found.", Status.NOT_FOUND);
            }

            originalFlight.delay(hours, minutes);
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