/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ManagementLists;
import Contracts.Contract;
import Persons.Clients;
import Vehicles.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bella
 */
public class ContractManagement {
    
    private List<Contract> contracts = new ArrayList<>();
    private int nextNumber = 1; // To assign consecutive numbers to contracts

    // Create a contract manually
    public Contract createContract(Clients client, Vehicle vehicle, LocalDate startDate, LocalDate endDate) throws Exception {
        validateClient(client);
        validateVehicle(vehicle);
        validateDates(startDate, endDate);
        validateAvailability(vehicle, startDate, endDate);

        Contract contract = new Contract(nextNumber++, client, vehicle, startDate, endDate);
        contracts.add(contract);
        return contract;
    }

    // Finalize a contract
    public void finalizeContract(int contractNumber) throws Exception {
        Contract contract = findContractByNumber(contractNumber);
        if (contract == null) throw new Exception("Contract not found");
        if (!contract.getStatus().equals("Active")) throw new Exception("Only active contracts can be finalized");
        contract.setStatus("Finished");
    }

    // Cancel a contract
    public void cancelContract(int contractNumber) throws Exception {
        Contract contract = findContractByNumber(contractNumber);
        if (contract == null) throw new Exception("Contract not found");
        if (!contract.getStatus().equals("Active")) throw new Exception("Only active contracts can be canceled");
        contract.setStatus("Canceled");
    }

    // Find contract by number
    public Contract findContractByNumber(int contractNumber) {
        return contracts.stream()
                .filter(c -> c.getContractNumber() == contractNumber)
                .findFirst()
                .orElse(null);
    }

    // Find contracts by client ID
    public List<Contract> findContractsByClient(String idNumber) {
        List<Contract> results = new ArrayList<>();
        for (Contract c : contracts) {
            int id = Integer.parseInt(idNumber);
            if (c.getClient().getId()== id) results.add(c);
        }
        return results;
    }

    // Find contracts by vehicle plate
    public List<Contract> findContractsByVehicle(String plate) {
        List<Contract> results = new ArrayList<>();
        for (Contract c : contracts) {
            if (c.getVehicle().getPlate().equals(plate)) results.add(c);
        }
        return results;
    }

    // -------- VALIDATIONS --------
    private void validateClient(Clients client) throws Exception {
        if (client == null) throw new Exception("Client not registered");
    }

    private void validateVehicle(Vehicle vehicle) throws Exception {
        if (vehicle == null) throw new Exception("Vehicle not registered");
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) throws Exception {
        if (startDate.isBefore(LocalDate.now())) throw new Exception("Start date cannot be before today");
        if (!endDate.isAfter(startDate)) throw new Exception("End date must be after start date");
    }

    private void validateAvailability(Vehicle vehicle, LocalDate startDate, LocalDate endDate) throws Exception {
        for (Contract c : contracts) {
            if (c.getVehicle().getPlate().equals(vehicle.getPlate()) && c.getStatus().equals("Active")) {
                if (overlaps(startDate, endDate, c.getStartDate(), c.getEndDate()))
                    throw new Exception("Vehicle is already rented for these dates");
            }
        }
    }

    private boolean overlaps(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }
    
    
}
