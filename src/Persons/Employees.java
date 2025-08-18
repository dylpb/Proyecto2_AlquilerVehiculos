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
public class Employees extends Person{
    
    private String position;
    private double salary;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employees(String position, double salary, int id, String name, String phone, String email, LocalDate birthDate) {
        super(id, name, phone, email, birthDate);
        this.position = position;
        this.salary = salary;
    }


    
}
