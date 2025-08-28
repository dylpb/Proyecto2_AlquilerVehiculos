/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLists;

import Methods.Method;
import Persons.Clients;
import Reservers.Reserve;
import Vehicles.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Bella
 */
public class ReservationManagment implements Method<Reserve>{
    
    private List<Reserve> reservations;
     private Queue<Reserve> waitingQueue;
      private List<Clients> registeredClients; // se usa para ver les clientes registrados
    private List<Vehicle> registeredVehicles; // Se usa para ver los  vehículos registrados

    public ReservationManagment(List<Clients> clients, List<Vehicle> vehicles) {
        this.reservations = new ArrayList<>();
        this.waitingQueue = new LinkedList<>();
        this.registeredClients = clients;
        this.registeredVehicles = vehicles;
    }

    // ------------ CREAR RESERVA
    @Override
    public boolean add(Reserve newReserve) throws Exception {
        if (newReserve == null) throw new Exception("La reserva no puede ser nula");

        // 1. Validar que cliente exista
        if (!isClientRegistered(newReserve.getClient())) {
            throw new Exception("El cliente con cédula " + newReserve.getClient().getId() + " no está registrado.");
        }

        // 2. Validar que vehículo exista
        if (!isVehicleRegistered(newReserve.getVehicle())) {
            throw new Exception("El vehículo con placa " + newReserve.getVehicle().getPlate() + " no está registrado.");
        }

        // 3. Validar fechas
        validateDates(newReserve.getStartDate(), newReserve.getEndDate());

        // 4. Verificar disponibilidad del vehículo
        if (!isVehicleAvailable(newReserve.getVehicle(), newReserve.getStartDate(), newReserve.getEndDate())) {
            waitingQueue.add(newReserve);
            newReserve.setStatus("EN_ESPERA");
            throw new Exception("El vehículo ya tiene una reserva activa en esas fechas. Se ha colocado en espera.");
        }

        // Si pasa todas las validaciones, se confirma
        newReserve.setStatus("CONFIRMADA");
        newReserve.getVehicle().setAvailable(false); 
        reservations.add(newReserve);
        return true;
    }

    // ------------ MODIFICAR RESERVA (ej: cambiar estado/vehículo si estaba en espera)
    @Override
    public boolean update(Reserve updatedReserve) throws Exception {
        if (updatedReserve == null) throw new Exception("La reserva a actualizar no puede ser nula");

        Reserve existing = search(updatedReserve.getClient().getId());
        if (existing != null && existing.getStatus().equals("EN_ESPERA")) {
            existing.setStatus(updatedReserve.getStatus());
            return true;
        }
        throw new Exception("No se pudo actualizar la reserva.");
    }

    // ------------ CANCELAR RESERVA (si no ha iniciado)
    @Override
    public boolean delete(Reserve toDelete) throws Exception {
        if (toDelete == null) throw new Exception("La reserva a eliminar no puede ser nula");

        if (toDelete.getStartDate().isAfter(LocalDate.now())) {
            reservations.remove(toDelete);
            toDelete.setStatus("CANCELADA");
            toDelete.getVehicle().setAvailable(true);
            return true;
        }
        throw new Exception("No se puede cancelar la reserva, ya ha iniciado o es inválida.");
    }

    // ------------ BUSCAR RESERVA (por cliente o fecha)
    @Override
    public Reserve search(Object key) {
        if (key instanceof Integer clientId) {
            for (Reserve r : reservations) {
                if (r.getClient().getId() == clientId) {
                    return r;
                }
            }
        } else if (key instanceof LocalDate date) {
            for (Reserve r : reservations) {
                if ((date.isEqual(r.getStartDate()) || date.isAfter(r.getStartDate())) &&
                    (date.isEqual(r.getEndDate()) || date.isBefore(r.getEndDate()))) {
                    return r;
                }
            }
        }
        return null;
    }

    // ------------ CONFIRMAR RESERVA (si estaba en espera)
    public boolean confirmReservation(Reserve r) throws Exception {
        if (r != null && r.getStatus().equals("EN_ESPERA") && isVehicleAvailable(r.getVehicle(), r.getStartDate(), r.getEndDate())) {
            r.setStatus("CONFIRMADA");
            r.getVehicle().setAvailable(false);
            reservations.add(r);
            waitingQueue.remove(r);
            return true;
        }
        throw new Exception("No se pudo confirmar la reserva.");
    }

    // ------------ VALIDAR FECHAS
    private void validateDates(LocalDate start, LocalDate end) throws Exception {
        if (start.isBefore(LocalDate.now())) {
            throw new Exception("La fecha de inicio no puede ser menor a la fecha actual.");
        }
        if (!end.isAfter(start)) {
            throw new Exception("La fecha de finalización debe ser posterior a la de inicio.");
        }
        if (ChronoUnit.DAYS.between(start, end) > 30) {
            throw new Exception("La reserva no puede superar los 30 días de duración.");
        }
    }

    // ------------ VERIFICAR DISPONIBILIDAD DE VEHÍCULO
    private boolean isVehicleAvailable(Vehicle v, LocalDate start, LocalDate end) {
        for (Reserve r : reservations) {
            if (r.getVehicle().getPlate().equals(v.getPlate()) &&
                r.getStatus().equals("CONFIRMADA")) {
                // Si se solapa en fechas, no disponible
                if (!(end.isBefore(r.getStartDate()) || start.isAfter(r.getEndDate()))) {
                    return false;
                }
            }
        }
        return true;
    }

    // ------------ VALIDAR CLIENTE REGISTRADO
    private boolean isClientRegistered(Clients c) {
        return registeredClients.stream().anyMatch(cli -> cli.getId() == c.getId());
    }

    // ------------ VALIDAR VEHÍCULO REGISTRADO
    private boolean isVehicleRegistered(Vehicle v) {
        return registeredVehicles.stream().anyMatch(veh -> veh.getPlate().equals(v.getPlate()));
    }
    
}
