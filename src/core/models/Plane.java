/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

/**
 *
 * @author edangulo
 */
public class Plane {
    
    private final String id;
    private String brand;
    private String model;
    private final int maxCapacity;
    private String airline;
    private List<Flight> flights; 

    public Plane(String id, String brand, String model, int maxCapacity, String airline) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
        this.flights = new ArrayList<>();
    }

    // Constructor de copia (necesario para el patrón Prototype)
    public Plane(Plane originalInstance) {
        this.id = originalInstance.id;
        this.brand = originalInstance.brand;
        this.model = originalInstance.model;
        this.maxCapacity = originalInstance.maxCapacity;
        this.airline = originalInstance.airline;
        this.flights = new ArrayList<>();
        if (originalInstance.flights != null) {
            for(Flight f : originalInstance.flights) {
                this.flights.add(new Flight(f)); 
            }
        }
    }

    public void addFlight(Flight flight) {
        boolean exists = false;
        for (Flight existingFlight : this.flights) {
            if (existingFlight.getId().equals(flight.getId())) { 
                exists = true;
                break;
            }
        }
        if (!exists) {
            this.flights.add(flight);
        }
    }
    
    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getAirline() {
        return airline;
    }

    /**
     * Devuelve una copia de la lista de vuelos asociados a este avión.
     * Esto previene modificaciones externas directas a la lista interna.
     * @return Una nueva lista conteniendo los vuelos del avión.
     */
    public List<Flight> getFlights() { 
        return new ArrayList<>(this.flights); // Devuelve una copia de la lista
    }
    
    public int getNumFlights() {
        return flights.size();
    }
}