/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author OreJr
 */
public class PeriodBirthdayController {

    public static boolean period(LocalDate birthDate, LocalDate today) {
        Period age = Period.between(birthDate, today);
        if (age.getYears() >= 130) { // CAMBIO: Límite de edad a 130
            return true;
        }
        return false;
    }
}
