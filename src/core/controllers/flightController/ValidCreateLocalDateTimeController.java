/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flightController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author OreJr
 */
public class ValidCreateLocalDateTimeController {

    public static LocalDateTime isValidLocalDateTime(int intYear,int intMonth,int intDay,int intHour,int intMinute) {
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.of(intYear, intMonth, intDay, intHour, intMinute);
            return localDateTime;
        } catch (DateTimeException e) {
            return localDateTime ;
        }
    }
    
    public static LocalDate isValidLocalDateTime(int intYear,int intMonth,int intDay) {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.of(intYear, intMonth, intMonth);
            return localDate;
        } catch (DateTimeException e) {
            return localDate ;
        }
    }
}
