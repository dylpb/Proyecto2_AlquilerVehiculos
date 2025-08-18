/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dylan
 */

public class UtilDate {
    public static int calculateAge(LocalDate date){
        return Period.between(date, LocalDate.now()).getYears();
    }
    
    public static boolean isNotFutureDate(LocalDate date){
        return !date.isAfter(LocalDate.now());
    }
    
    public static boolean isLegalAge(LocalDate date){
        return calculateAge(date)>=18;
    }
    
    //recibe string y pasa a localdate
    public static LocalDate toLocalDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    //recibe localdate y pasa a string
    public static String toString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
