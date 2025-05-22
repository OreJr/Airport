/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edangulo
 */
public class Flight {
    
    private final String id;
    private List<Passenger> passengers; 
    private Plane plane;
    private Location departureLocation;
    private Location scaleLocation;
    private Location arrivalLocation;
    private LocalDateTime departureDate;
    private int hoursDurationArrival;
    private int minutesDurationArrival;
    private int hoursDurationScale;
    private int minutesDurationScale;
    
    public Flight(String id, Plane plane, Location departureLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = 0; 
        this.minutesDurationScale = 0;
        
        if (this.plane != null) {
            this.plane.addFlight(this); 
        }
    }

    public Flight(String id, Plane plane, Location departureLocation, Location scaleLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival, int hoursDurationScale, int minutesDurationScale) {
        this.id = id;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.departureLocation = departureLocation;
        this.scaleLocation = scaleLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.hoursDurationArrival = hoursDurationArrival;
        this.minutesDurationArrival = minutesDurationArrival;
        this.hoursDurationScale = hoursDurationScale;
        this.minutesDurationScale = minutesDurationScale;
        
        if (this.plane != null) {
           this.plane.addFlight(this); 
        }
    }
    
    // Constructor de copia (necesario para el patrón Prototype)
    public Flight(Flight originalInstance) {
        this.id = originalInstance.id;
        this.passengers = new ArrayList<>();
        if (originalInstance.passengers != null) {
            for(Passenger p : originalInstance.passengers) {
                this.passengers.add(new Passenger(p)); 
            }
        }
        
        if (originalInstance.plane != null) {
            this.plane = new Plane(originalInstance.plane);
        } else {
            this.plane = null;
        }
        
        if (originalInstance.departureLocation != null) {
            this.departureLocation = new Location(originalInstance.departureLocation);
        } else {
            this.departureLocation = null;
        }

        if (originalInstance.scaleLocation != null) {
            this.scaleLocation = new Location(originalInstance.scaleLocation);
        } else {
            this.scaleLocation = null;
        }

        if (originalInstance.arrivalLocation != null) {
            this.arrivalLocation = new Location(originalInstance.arrivalLocation);
        } else {
            this.arrivalLocation = null;
        }
        
        this.departureDate = originalInstance.departureDate; 
        this.hoursDurationArrival = originalInstance.hoursDurationArrival;
        this.minutesDurationArrival = originalInstance.minutesDurationArrival;
        this.hoursDurationScale = originalInstance.hoursDurationScale;
        this.minutesDurationScale = originalInstance.minutesDurationScale;
    }
    
    public void addPassenger(Passenger passenger) {
        boolean exists = false;
        for (Passenger existingPassenger : this.passengers) {
            if (existingPassenger.getId() == passenger.getId()) {
                exists = true;
                break;
            }
        }
        if (!exists) {
             this.passengers.add(passenger);
        }
    }

    /**
     * Devuelve una copia de la lista de pasajeros en este vuelo.
     * Esto previene modificaciones externas directas a la lista interna.
     * @return Una nueva lista conteniendo los pasajeros del vuelo.
     */
    public List<Passenger> getPassengers() { 
        return new ArrayList<>(this.passengers); // Devuelve una copia de la lista
    }
    
    public String getId() {
        return id;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public Location getScaleLocation() {
        return scaleLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public int getHoursDurationArrival() {
        return hoursDurationArrival;
    }

    public int getMinutesDurationArrival() {
        return minutesDurationArrival;
    }

    public int getHoursDurationScale() {
        return hoursDurationScale;
    }

    public int getMinutesDurationScale() {
        return minutesDurationScale;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
    
    public LocalDateTime calculateArrivalDate() {
        if (this.departureDate == null) return null; 
        return departureDate.plusHours(hoursDurationScale).plusHours(hoursDurationArrival).plusMinutes(minutesDurationScale).plusMinutes(minutesDurationArrival);
    }
    
    public void delay(int hours, int minutes) {
        if (this.departureDate == null) return; 
        this.departureDate = this.departureDate.plusHours(hours).plusMinutes(minutes);
    }
    
    public int getNumPassengers() {
        return passengers.size();
    }

    public Iterable<Passenger> getPassengers() {
        throw new UnsupportedOperationException("Not supported yetaS."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}