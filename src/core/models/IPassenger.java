package core.models;

import core.utils.CopyContext;
import java.time.LocalDate;
import java.util.List;

public interface IPassenger {
    long getId();
    String getFirstname();
    void setFirstname(String firstname);
    String getLastname();
    void setLastname(String lastname);
    LocalDate getBirthDate();
    void setBirthDate(LocalDate birthDate);
    int getCountryPhoneCode();
    void setCountryPhoneCode(int countryPhoneCode);
    long getPhone();
    void setPhone(long phone);
    String getCountry();
    void setCountry(String country);
    List<IFlight> getFlights();
    void addFlight(IFlight flight);
    String getFullname();
    String generateFullPhone();
    int calculateAge();
    int getNumFlights();

    IPassenger copy(CopyContext context);
    default IPassenger copy() {
        return copy(new CopyContext());
    }
}