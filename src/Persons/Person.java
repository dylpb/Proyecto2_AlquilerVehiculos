/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persons;

import Utils.UtilDate;
import java.time.LocalDate;

/**
 *
 * @author Dylan
 */
public abstract class Person {
    
    private int id;
    private String name, phone, email;
    private LocalDate birthDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (validatePhone(phone))
            this.phone = phone;
    }
    
    private static boolean validatePhone(String phone){
        return phone.matches("^[0-9]{8}$");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email))
            this.email = email;
    }
    
    private static boolean validateEmail(String email){
        return email.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge(){
        return UtilDate.calculateAge(birthDate);
    }    

    public Person(int id, String name, String phone, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        if(validatePhone(phone))
            this.phone = phone;
        if(validateEmail(email))
            this.email = email;        
        if (UtilDate.isNotFutureDate(birthDate))
            this.birthDate = birthDate;
    }

   
}
