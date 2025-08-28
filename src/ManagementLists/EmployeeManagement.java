/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLists;

import Methods.Method;
import Persons.Employees;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dylan
 */
public class EmployeeManagement implements Method<Employees>{
    
    List <Employees> listE;
    
        public EmployeeManagement() {
        this.listE = new ArrayList<>();
    }
    

//------------AGREGAR
    @Override
    public boolean add(Employees newemployee) {
        if (search(newemployee.getId()) != null) {
            return false;
        }
        listE.add(newemployee);
        return true;  
    }
//------------ACTUALIZAR
    @Override
    public boolean update(Employees updatedemployee) {
        if (updatedemployee == null) {//Es el dato ingresado valido?
         return false;  //no hace nada si es nulo, ya que esta vacio
        }
    Employees employeeExists = search(updatedemployee.getId());//Busca si el empleado ya esta en la lista
    
    if (employeeExists != null) {
        employeeExists.setPhone(updatedemployee.getPhone());
        employeeExists.setEmail(updatedemployee.getEmail());
        employeeExists.setPosition(updatedemployee.getPosition());
        employeeExists.setSalary(updatedemployee.getSalary());
        return true; // devuelve true si se actualiza correctamente
    }
        return false; //Este se usa si al buscar al empleado, no se encuentra, por lo tanto es inactualizable
}
//------------ELIMINAR
    @Override
    public boolean delete(Employees deletedemployee) {
        if (deletedemployee == null) {
         return false;  //no hace nada si es nulo
        }
    Employees employeeExists = search(deletedemployee.getId());
    
    if (employeeExists != null) {
        listE.remove(employeeExists); 
        return true;
    }   
return false;  
}
//------------BUSCAR  
    @Override
    public Employees search(Object id) {
    if (id instanceof Integer employeeId) { // Conversión segura a Integer
        for (Employees employee : listE) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
    }
    return null;
}
    
    
}
