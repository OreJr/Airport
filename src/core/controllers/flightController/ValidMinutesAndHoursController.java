/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class ValidMinutesAndHoursController {

    public static boolean isValid(int intHoursDuration, int intMinutesDuration) {
        if (intHoursDuration < 0 || intMinutesDuration < 0 || (intHoursDuration == 0 && intMinutesDuration == 0)) {
            return false;
        }
        return true;
    }
}
