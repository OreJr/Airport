/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.passengerController;

/**
 *
 * @author OreJr
 */
public class ValidNumberAndCapacityController {

    public static boolean isValidNumber(int intValue,int number) {
        if (intValue < 0 || String.valueOf(intValue).length() > number) {
            return false;
        }
        return true;
    }

    public static boolean isValidNumber(long longValue) {
        if (longValue < 0 || String.valueOf(longValue).length() > 11) {
            return false;
        }
        return true;
    }
}
