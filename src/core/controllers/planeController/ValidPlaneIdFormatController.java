/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.planeController;

/**
 *
 * @author JorgeDuarte 
 */
public class ValidPlaneIdFormatController {

    public static boolean isValidPlaneIdFormat(String id) {
        if (id == null || id.length() != 7) { 
            return false;
        }
        for (int i = 0; i < 2; i++) { 
            char c = id.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        for (int i = 2; i < 7; i++) { 
            char c = id.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}