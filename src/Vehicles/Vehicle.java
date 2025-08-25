/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author bycha
 */
public class Vehicle {
    
    int Year;
    
    enum Marca{
        TOYAYA,SASUKI,SETA,DAHON,ZULES,SUBARASHI
    }
    enum Modelo{
        MINI,CRUSERO,FAMILIAR,APACHE,Triciclo
    }
   enum Tipo{
       Sedán,Suv,Pick_up,Hashback,Crossover,Coupé,Minivan
   }
    public static void main(String[]args){
        
   Map<Integer, String> registroPlacas = new LinkedHashMap<>();
   registroPlacas.put(001, "ABCD");
   registroPlacas.put(002, "ABCD");
   registroPlacas.put(003, "ABCD");
   
}

    public Vehicle(int Year) {
        this.Year = Year;
    }

    public int getYera() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }
    
}
