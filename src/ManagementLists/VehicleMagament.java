/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLists;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import Vehicles.Vehicle;
import Vehicles.VehicleEnumStade;
import Vehicles.VehicleTypeEnum;
/**
 *
 * @author Bella
 */
public class VehicleMagament {
 private Map<String, Vehicle> vehicles = new HashMap<>();

        
    

    /**
     * Add a new vehicle to the system.
     * @param vehicle The vehicle to add.
     * @throws IllegalArgumentException if validations fail.
     */
    public void addVehicle(Vehicle vehicle) {
        // Validation: Plate must be unique
        if (vehicles.containsKey(vehicle.getPlate())) {
            throw new IllegalArgumentException("A vehicle with this plate already exists.");
        }

        // Validation: Year must not be in the future and not older than 20 years
        int currentYear = Year.now().getValue();
        if (vehicle.getYear() > currentYear || vehicle.getYear() < (currentYear - 20)) {
            throw new IllegalArgumentException("Invalid year: must not be in the future and not older than 20 years.");
        }

        // Validation: Type must be in predefined enum list
        if (vehicle.getType() == null) {
            throw new IllegalArgumentException("Vehicle type is invalid.");
        }

        // Validation: Status must be valid enum
        if (vehicle.getStatus() == null) {
            throw new IllegalArgumentException("Vehicle status is invalid.");
        }

        vehicles.put(vehicle.getPlate(), vehicle);
    }

  
    public void updateVehicle(String plate, String newModel, VehicleTypeEnum newType, VehicleEnumStade newStatus) {
 Vehicle v = vehicles.get(plate);
    if (v == null) {
        throw new IllegalArgumentException("Vehicle with plate " + plate + " does not exist.");
    }

    v.setModel(newModel);
    try {
        v.setType(newType);
        v.setStatus(newStatus);
    } catch (Exception e) {
        throw new RuntimeException("Error updating vehicle", e);
    }
    }

    /**
     * Delete a vehicle, only if it is not rented.
     * @param plate Plate of vehicle to delete.
     * @throws IllegalArgumentException if vehicle does not exist or is rented.
     */
    public void deleteVehicle(String plate) {
        Vehicle v = vehicles.get(plate);
        if (v == null) {
            throw new IllegalArgumentException("Vehicle with plate " + plate + " does not exist.");
        }

        if (v.getStatus() == VehicleEnumStade.NOT_AVAILABLE) {
            throw new IllegalArgumentException("Cannot delete a vehicle that is currently rented.");
        }

        vehicles.remove(plate);
    }

    /**
     * Find and return a vehicle by its plate.
     * @param plate Plate of vehicle.
     * @return Vehicle if found.
     * @throws IllegalArgumentException if not found.
     */
    public Vehicle findVehicle(String plate) {
        Vehicle v = vehicles.get(plate);
        if (v == null) {
            throw new IllegalArgumentException("Vehicle with plate " + plate + " does not exist.");
        }
        return v;
    }

  
    public void showAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            vehicles.values().forEach(System.out::println);
        }
    }

}