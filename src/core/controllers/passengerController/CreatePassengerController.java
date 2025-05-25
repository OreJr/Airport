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
public class CreatePassengerController {
    public static Passenger createPassenger(long id, String firstname, String lastname, LocalDate birthDate, int countryPhoneCode, long phone, String country) {
        Passenger newPassenger = new Passenger(id, firstname, lastname, birthDate, countryPhoneCode, phone, country);

        return newPassenger;
    }
}
