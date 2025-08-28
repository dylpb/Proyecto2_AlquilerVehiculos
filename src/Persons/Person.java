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
        if (phone == null || phone.isBlank() || !validatePhone(phone)){
            throw new IllegalArgumentException("El formato del teléfono es incorrecto, digite solo 8 números.");
        }
        this.phone = phone;
    }
    
    private static boolean validatePhone(String phone){
        return phone.matches("^[0-9]{8}$");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email==null || email.isBlank() || !validateEmail(email)){
        throw new IllegalArgumentException("El formato del email es incorrecto.");
        }
        this.email = email;
    }//validar email y telefono
    
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
        if (id<=0) {
        throw new IllegalArgumentException("Digite un ID válido.");
        }        
        if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("Digite un nombre correcto,no puedo estar vacio.");
        }
        if(phone == null || phone.isBlank() || !validatePhone(phone)){
        throw new IllegalArgumentException("El formato del teléfono es incorrecto, digite solo 8 números.");
        }
        if(email == null || email.isBlank() || !validateEmail(email)){
        throw new IllegalArgumentException("El formato del email es incorrecto.");
        }
        if (birthDate == null || !UtilDate.isNotFutureDate(birthDate) || !UtilDate.isLegalAge(birthDate)){
        throw new IllegalArgumentException("La fecha de nacimiento es incorrecta.");
        }
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

   
}
