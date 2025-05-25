/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class ValidMinutesController {

    public static boolean isValid(int intMinutesDurationArrival) {
        if (intMinutesDurationArrival >= 60) {
            return false;
        }
        return true;
    }
}
