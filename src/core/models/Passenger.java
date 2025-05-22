/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author edangulo
 */
public class Passenger {
    
    private final long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private int countryPhoneCode;
    private long phone;
    private String country;
    private List<Flight> flights;

    public Passenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone, String country) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.countryPhoneCode = countryPhoneCode;
        this.phone = phone;
        this.country = country;
        this.flights = new ArrayList<>();
    }

    // Constructor de copia (necesario para el patrón Prototype)
    public Passenger(Passenger originalInstance) {
        this.id = originalInstance.id;
        this.firstname = originalInstance.firstname;
        this.lastname = originalInstance.lastname;
        this.birthDate = originalInstance.birthDate; 
        this.countryPhoneCode = originalInstance.countryPhoneCode;
        this.phone = originalInstance.phone;
        this.country = originalInstance.country;
        this.flights = new ArrayList<>();
        if (originalInstance.flights != null) {
            for(Flight f : originalInstance.flights){
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
    
    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getCountryPhoneCode() {
        return countryPhoneCode;
    }

    public long getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    /**
     * Devuelve una copia de la lista de vuelos asociados a este pasajero.
     * Esto previene modificaciones externas directas a la lista interna.
     * @return Una nueva lista conteniendo los vuelos del pasajero.
     */
    public List<Flight> getFlights() { 
        return new ArrayList<>(this.flights); // Devuelve una copia de la lista
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCountryPhoneCode(int countryPhoneCode) {
        this.countryPhoneCode = countryPhoneCode;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getFullname() {
        return firstname + " " + lastname;
    }
    
    public String generateFullPhone() {
        return "+" + countryPhoneCode + " " + phone;
    }
    
    public int calculateAge() {
        if (this.birthDate == null) return 0; 
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    public int getNumFlights() {
        return flights.size();
    }
}