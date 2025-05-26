/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

import java.time.LocalDate;

/**
 *
 * @author OreJr
 */
public class AfterTodayController {
    public static boolean isAfterToToday(LocalDate birthDate, LocalDate today) {
        if (birthDate.isAfter(today)) {
            return true;
        }
        return false;
    }
}
