/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservers;

import Persons.Clients;
import Vehicles.Vehicle;
import java.time.LocalDate;

/**
 *
 * @author Bella
 */
public class Reserve {
    
    private Clients client;
    private Vehicle vehicle;
    private LocalDate endDate;
    private LocalDate startDate;
    private String status;

    public Reserve(Clients client, Vehicle vehicle, LocalDate endDate, LocalDate startDate, String status) {
        this.client = client;
        this.vehicle = vehicle;
        this.endDate = endDate;
        this.startDate = startDate;
        this.status = "Waiting";
    }

    public Clients getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
