/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

/**
 *
 * @author OreJr
 */
public class ValidTimeProvidedController {
    public static boolean isValid(String string) {
        if (string!= null && !string.trim().isEmpty()) {
            return false;
        }
        return true ;
    }
}
