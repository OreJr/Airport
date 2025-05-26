/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

/**
 *
 * @author OreJr
 */
public class ValidPassengerIdFormatController {
    public static boolean isValidPassengerIdFormat(long id) {
        if (id < 0 || String.valueOf(id).length() > 15) {
            return false;
        }

        return true;
    }
}
