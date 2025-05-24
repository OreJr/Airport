/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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

    // Constructor de copia principal (usado por el controlador al devolver una respuesta)
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
            for(Flight f_original : originalInstance.flights){
                // Al copiar un vuelo como parte de un pasajero, le pasamos este pasajero (que es la copia)
                // para que el vuelo copiado sepa a qué instancia de pasajero (copia) pertenece en este contexto,
                // y para que el constructor de copia de Flight maneje la recursión adecuadamente.
                this.flights.add(new Flight(f_original, this)); 
            }
        }
    }
    
    /**
     * Constructor de copia contextual, usado principalmente por Flight al copiar su lista de pasajeros.
     * El flag shallowCopyForFlight evita que este constructor intente a su vez copiar profundamente
     * la lista de vuelos del pasajero, rompiendo el ciclo recursivo.
     * Su visibilidad es 'protected' porque solo debería ser llamado por clases dentro del mismo paquete
     * o subclases, en este caso, Flight.
     */
    protected Passenger(Passenger originalInstance, boolean shallowCopyOfItsFlights) {
        this.id = originalInstance.id;
        this.firstname = originalInstance.firstname;
        this.lastname = originalInstance.lastname;
        this.birthDate = originalInstance.birthDate; 
        this.countryPhoneCode = originalInstance.countryPhoneCode;
        this.phone = originalInstance.phone;
        this.country = originalInstance.country;
        if (shallowCopyOfItsFlights) {
            this.flights = new ArrayList<>(); // En una copia superficial para Vuelo, no copiamos la lista de vuelos del pasajero.
        } else {
            // Comportamiento de copia profunda normal si no es una copia superficial contextual
            this.flights = new ArrayList<>();
             if (originalInstance.flights != null) {
                for(Flight f_original : originalInstance.flights){
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
    
    public long getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public LocalDate getBirthDate() { return birthDate; }
    public int getCountryPhoneCode() { return countryPhoneCode; }
    public long getPhone() { return phone; }
    public String getCountry() { return country; }
    public List<Flight> getFlights() { return new ArrayList<>(this.flights); } // Devuelve copia de la lista
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setCountryPhoneCode(int countryPhoneCode) { this.countryPhoneCode = countryPhoneCode; }
    public void setPhone(long phone) { this.phone = phone; }
    public void setCountry(String country) { this.country = country; }
    public String getFullname() { return firstname + " " + lastname; }
    public String generateFullPhone() { return "+" + countryPhoneCode + " " + phone; }
    public int calculateAge() { if (this.birthDate == null) return 0; return Period.between(birthDate, LocalDate.now()).getYears(); }
    public int getNumFlights() { return flights.size(); }
}