/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import java.time.LocalDate;

/**
 *
 * @author OreJr
 */
public class ValidDepartureYearController {

    public static boolean isValidDepartureYear(int intYear) {
        int currentYear = LocalDate.now().getYear();
        if (intYear < currentYear) {
            return false;
        }
        return true;
    }
}
