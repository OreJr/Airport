package core.models;

import core.utils.CopyContext;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Passenger implements IPassenger {
    
    private final long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private int countryPhoneCode;
    private long phone;
    private String country;
    private List<IFlight> flights;

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
    
    @Override
    public long getId() { return id; }
    @Override
    public String getFirstname() { return firstname; }
    @Override
    public void setFirstname(String firstname) { this.firstname = firstname; }
    @Override
    public String getLastname() { return lastname; }
    @Override
    public void setLastname(String lastname) { this.lastname = lastname; }
    @Override
    public LocalDate getBirthDate() { return birthDate; }
    @Override
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    @Override
    public int getCountryPhoneCode() { return countryPhoneCode; }
    @Override
    public void setCountryPhoneCode(int countryPhoneCode) { this.countryPhoneCode = countryPhoneCode; }
    @Override
    public long getPhone() { return phone; }
    @Override
    public void setPhone(long phone) { this.phone = phone; }
    @Override
    public String getCountry() { return country; }
    @Override
    public void setCountry(String country) { this.country = country; }
    
    @Override
    public List<IFlight> getFlights() { 
        return new ArrayList<>(this.flights);
    }
    
    @Override
    public void addFlight(IFlight flight) {
        if (flight == null) return;
        boolean exists = false;
        for (IFlight existingFlight : this.flights) {
            if (existingFlight.getId().equals(flight.getId())) { 
                exists = true;
                break;
            }
        }
        if (!exists) {
            this.flights.add(flight);
        }
    }
    
    @Override
    public String getFullname() { return firstname + " " + lastname; }
    @Override
    public String generateFullPhone() { return "+" + countryPhoneCode + " " + phone; }
    @Override
    public int calculateAge() { if (this.birthDate == null) return 0; return Period.between(birthDate, LocalDate.now()).getYears(); }
    @Override
    public int getNumFlights() { return this.flights.size(); }

    @Override
    public IPassenger copy(CopyContext context) {
        IPassenger existingCopy = context.getCopied(this);
        if (existingCopy != null) {
            return existingCopy;
        }

        Passenger newPassenger = new Passenger(this.id, this.firstname, this.lastname, this.birthDate, this.countryPhoneCode, this.phone, this.country);
        context.registerCopy(this, newPassenger); // Registrar la copia ANTES de copiar campos referenciados

        if (this.flights != null) {
            for (IFlight originalFlight : this.flights) {
                if (originalFlight != null) {
                    newPassenger.addFlight(originalFlight.copy(context));
                }
            }
        }
        return newPassenger;
    }
}