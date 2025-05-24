/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    
    /**
     * Constructor de copia principal. Usado por los controladores para devolver una copia independiente.
     * Este constructor inicia una copia "superficial controlada" de las entidades Plane y Passenger
     * para evitar la recursión infinita que causa StackOverflowError.
     * @param originalInstance La instancia original de Flight a copiar.
     */
    public Flight(Flight originalInstance) {
        this.id = originalInstance.id;
        this.departureDate = originalInstance.departureDate;
        this.hoursDurationArrival = originalInstance.hoursDurationArrival;
        this.minutesDurationArrival = originalInstance.minutesDurationArrival;
        this.hoursDurationScale = originalInstance.hoursDurationScale;
        this.minutesDurationScale = originalInstance.minutesDurationScale;

        // Las localizaciones son simples y no causan ciclos, se copian normalmente.
        if (originalInstance.departureLocation != null) {
            this.departureLocation = new Location(originalInstance.departureLocation);
        }
        if (originalInstance.arrivalLocation != null) {
            this.arrivalLocation = new Location(originalInstance.arrivalLocation);
        }
        if (originalInstance.scaleLocation != null) {
            this.scaleLocation = new Location(originalInstance.scaleLocation);
        }

        // Para el avión, usamos el constructor de copia contextual de Plane que NO copia su lista de vuelos.
        if (originalInstance.plane != null) {
            this.plane = new Plane(originalInstance.plane, true); // true indica una copia superficial de la lista de vuelos del avión
        }
        
        // Para los pasajeros, usamos el constructor de copia contextual de Passenger que NO copia su lista de vuelos.
        this.passengers = new ArrayList<>();
        if (originalInstance.passengers != null) {
            for(Passenger p_original : originalInstance.passengers) {
                this.passengers.add(new Passenger(p_original, true)); // true indica una copia superficial de la lista de vuelos del pasajero
            }
        }
    }

    /**
     * Constructor de copia contextual, llamado cuando un Pasajero está siendo copiado.
     * Se asegura de que el pasajero en la lista de este vuelo sea la copia del pasajero que se está creando,
     * y que otros pasajeros y el avión se copien de forma superficial para evitar ciclos.
     * @param originalInstance El Vuelo original a copiar.
     * @param passengerContext La instancia de Pasajero (copia) que está "conteniendo" esta copia de Vuelo.
     */
    protected Flight(Flight originalInstance, Passenger passengerContext) {
        this.id = originalInstance.id;
        this.departureDate = originalInstance.departureDate;
        this.hoursDurationArrival = originalInstance.hoursDurationArrival;
        this.minutesDurationArrival = originalInstance.minutesDurationArrival;
        this.hoursDurationScale = originalInstance.hoursDurationScale;
        this.minutesDurationScale = originalInstance.minutesDurationScale;

        if (originalInstance.departureLocation != null) this.departureLocation = new Location(originalInstance.departureLocation);
        if (originalInstance.arrivalLocation != null) this.arrivalLocation = new Location(originalInstance.arrivalLocation);
        if (originalInstance.scaleLocation != null) this.scaleLocation = new Location(originalInstance.scaleLocation);

        // Copia superficial del avión
        if (originalInstance.plane != null) {
            this.plane = new Plane(originalInstance.plane, true); 
        }
        
        this.passengers = new ArrayList<>();
        boolean passengerContextAdded = false;
        if (originalInstance.passengers != null) {
            for (Passenger p_original : originalInstance.passengers) {
                if (p_original.getId() == passengerContext.getId()) {
                    this.passengers.add(passengerContext); // Usar la copia del pasajero que ya se está creando
                    passengerContextAdded = true;
                } else {
                    // Otros pasajeros en la lista original del vuelo se copian superficialmente
                    this.passengers.add(new Passenger(p_original, true)); 
                }
            }
        }
        // Si el passengerContext no estaba en la lista original de pasajeros del vuelo original,
        // pero este vuelo se está copiando *para* ese passengerContext, debería añadirse.
        // Sin embargo, la lógica de addFlight en Passenger ya maneja la adición del vuelo al pasajero.
        // Esta lógica asegura que si el vuelo original contenía al pasajero original, la copia del vuelo contendrá la copia del pasajero.
    }
    
    /**
     * Constructor de copia contextual, llamado cuando un Avión está siendo copiado.
     * Se asegura de que el avión de este vuelo sea la copia del avión que se está creando,
     * y que los pasajeros se copien de forma superficial para evitar ciclos.
     * @param originalInstance El Vuelo original a copiar.
     * @param planeContext La instancia de Avión (copia) que está "conteniendo" esta copia de Vuelo.
     */
    protected Flight(Flight originalInstance, Plane planeContext) {
        this.id = originalInstance.id;
        this.departureDate = originalInstance.departureDate;
        this.hoursDurationArrival = originalInstance.hoursDurationArrival;
        this.minutesDurationArrival = originalInstance.minutesDurationArrival;
        this.hoursDurationScale = originalInstance.hoursDurationScale;
        this.minutesDurationScale = originalInstance.minutesDurationScale;

        if (originalInstance.departureLocation != null) this.departureLocation = new Location(originalInstance.departureLocation);
        if (originalInstance.arrivalLocation != null) this.arrivalLocation = new Location(originalInstance.arrivalLocation);
        if (originalInstance.scaleLocation != null) this.scaleLocation = new Location(originalInstance.scaleLocation);

        this.plane = planeContext; // Usar la copia del avión que ya se está creando
        
        this.passengers = new ArrayList<>();
        if (originalInstance.passengers != null) {
            for (Passenger p_original : originalInstance.passengers) {
                // Copia superficial de los pasajeros
                this.passengers.add(new Passenger(p_original, true)); 
            }
        }
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
    
    public List<Passenger> getPassengers() { return new ArrayList<>(this.passengers); }
    public String getId() { return id; }
    public Location getDepartureLocation() { return departureLocation; }
    public Location getScaleLocation() { return scaleLocation; }
    public Location getArrivalLocation() { return arrivalLocation; }
    public LocalDateTime getDepartureDate() { return departureDate; }
    public int getHoursDurationArrival() { return hoursDurationArrival; }
    public int getMinutesDurationArrival() { return minutesDurationArrival; }
    public int getHoursDurationScale() { return hoursDurationScale; }
    public int getMinutesDurationScale() { return minutesDurationScale; }
    public Plane getPlane() { return plane; }
    public void setDepartureDate(LocalDateTime departureDate) { this.departureDate = departureDate; }
    public LocalDateTime calculateArrivalDate() { if (this.departureDate == null) return null; return departureDate.plusHours(hoursDurationScale).plusHours(hoursDurationArrival).plusMinutes(minutesDurationScale).plusMinutes(minutesDurationArrival); }
    public void delay(int hours, int minutes) { if (this.departureDate == null) return; this.departureDate = this.departureDate.plusHours(hours).plusMinutes(minutes); }
    public int getNumPassengers() { return passengers.size(); }
}