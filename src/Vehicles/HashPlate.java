/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehicles;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bycha
 */
public class HashPlate {
   
    Map<Integer,String> hashPlaca = new HashMap<>();
    //Hashmap de los autos
    hashPlaca.put(1, "A001");
    hashPlaca.put(2, "A002");
    hashPlaca.put(3, "A003");
    hashPlaca.put(4, "A004");
    hashPlaca.put(5, "A005");
    hashPlaca.put(6, "B001");
    hashPlaca.put(7, "B002");
    hashPlaca.put(8, "B003");
    hashPlaca.put(9, "B004");
    hashPlaca.put(10, "B005");
    
    
    boolean consultaplaca=hashPlaca.containsValue("B005");
    
    
    if(consultaplaca==true){
        System.out.println("La placa si existe");
    }else{
        System.out.println("La placa no exite");
}
}

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public HashPlate() {
    }
}
