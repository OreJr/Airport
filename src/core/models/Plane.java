/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;
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

    // Constructor de copia principal
    public Plane(Plane originalInstance) {
        this.id = originalInstance.id;
        this.brand = originalInstance.brand;
        this.model = originalInstance.model;
        this.maxCapacity = originalInstance.maxCapacity;
        this.airline = originalInstance.airline;
        this.flights = new ArrayList<>();
        if (originalInstance.flights != null) {
            for(Flight f_original : originalInstance.flights) {
                // Al copiar un vuelo como parte de un avión, le pasamos este avión (copia)
                this.flights.add(new Flight(f_original, this)); 
            }
        }
    }
    
    /**
     * Constructor de copia contextual, usado principalmente por Flight al copiar su avión.
     * El flag shallowCopyOfItsFlights evita que este constructor intente a su vez copiar profundamente
     * la lista de vuelos del avión, rompiendo el ciclo recursivo.
     */
    protected Plane(Plane originalInstance, boolean shallowCopyOfItsFlights) {
        this.id = originalInstance.id;
        this.brand = originalInstance.brand;
        this.model = originalInstance.model;
        this.maxCapacity = originalInstance.maxCapacity;
        this.airline = originalInstance.airline;
        if (shallowCopyOfItsFlights) {
            this.flights = new ArrayList<>(); // En una copia superficial para Vuelo, no copiamos la lista de vuelos del avión.
        } else {
            // Comportamiento de copia profunda normal
            this.flights = new ArrayList<>();
            if (originalInstance.flights != null) {
                for(Flight f_original : originalInstance.flights) {
                    this.flights.add(new Flight(f_original, this));
                }
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
    
    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getMaxCapacity() { return maxCapacity; }
    public String getAirline() { return airline; }
    public List<Flight> getFlights() { return new ArrayList<>(this.flights); } // Devuelve copia de la lista
    public int getNumFlights() { return flights.size(); }
}