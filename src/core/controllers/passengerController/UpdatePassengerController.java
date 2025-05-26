/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import core.models.Passenger;
import java.time.LocalDate;

/**
 *
 * @author OreJr
 */
public class UpdatePassengerController {

    public static boolean UpdatePassenger(Passenger passengerToUpdate, String firstname, String lastname,
            LocalDate birthdate, int intPhoneCode, long longPhone, String country) {
        try {
            passengerToUpdate.setFirstname(firstname.trim());
            passengerToUpdate.setLastname(lastname.trim());
            passengerToUpdate.setBirthDate(birthdate);
            passengerToUpdate.setCountryPhoneCode(intPhoneCode);
            passengerToUpdate.setPhone(longPhone);
            passengerToUpdate.setCountry(country.trim());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
