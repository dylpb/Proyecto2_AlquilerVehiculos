/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLists;

import Methods.Method;
import Persons.Clients;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dylan
 */
public class ClientManagement implements Method{
    
    List <Clients> listC;

    public ClientManagement() {
        this.listC = new ArrayList<>();
    }
    

    public void add(Clients newclient) {
        if (newclient != null) {
        listC.add(newclient);
        }
    }

    public void update(String license, String phone, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
