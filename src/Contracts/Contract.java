/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contracts;
import Persons.Clients;
import Vehicles.Vehicle;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author Bella
 */
public class Contract {
    
        private int contractNumber;
    private Clients client;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;
    private String status; // "Active", "Finished", "Canceled"

    // Constructor
    public Contract(int contractNumber, Clients client, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.contractNumber = contractNumber;
        this.client = client;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Active"; // When created, the contract starts as Active
        calculateTotalAmount();
        // Set vehicle as unavailable
        this.vehicle.setAvailable(false);
    }

    // Calculate the total amount based on daily rate and rental days
    private void calculateTotalAmount() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        this.totalAmount = days * vehicle.getDailyRate();
    }

    // Getters
    public int getContractNumber() { return contractNumber; }
    public Clients getClient() { return client; }
    public Vehicle getVehicle() { return vehicle; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }

    // Change contract status
    public void setStatus(String status) { 
        this.status = status; 
        // If finished or canceled, free the vehicle
        if(status.equals("Finished") || status.equals("Canceled")){
            vehicle.setAvailable(true);
        }
    }

    @Override
    public String toString() {
        return "Contract #" + contractNumber + " - Client: " + client.getName() 
               + " - Vehicle: " + vehicle.getPlate() + " - Status: " + status
               + " - Total: " + totalAmount;
    }
    
}
