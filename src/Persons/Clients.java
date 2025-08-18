/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persons;

import java.time.LocalDate;

/**
 *
 * @author Dylan
 */
public class Clients extends Person{
    
    private String license;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    
    
    public Clients(String license, int id, String name, String phone, String email, LocalDate birthDate) {
        super(id, name, phone, email, birthDate);
        this.license = license;
    }

}
