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
public class ClientManagement implements Method<Clients>{
    
    List <Clients> listC;

    public ClientManagement() {
        this.listC = new ArrayList<>();
    }
    
//------------AGREGAR
    @Override
    public boolean add(Clients newclient) {
        if (search(newclient.getId()) != null) {
            return false;
        }
        listC.add(newclient);
        return true;
    }
//------------ACTUALIZAR
    @Override
    public boolean update(Clients updatedClient) {
        if (updatedClient == null) {
         return false;  //no hace nada si es nulo
        }
    Clients clientExists = search(updatedClient.getId());
    
    if (clientExists != null) {
        clientExists.setPhone(updatedClient.getPhone());
        clientExists.setEmail(updatedClient.getEmail());
        clientExists.setLicense(updatedClient.getLicense());
        return true;
    }
        return false;
}
//------------ELIMINAR
    @Override
    public boolean delete(Clients deletedClient) {
        if (deletedClient == null) {
         return false;  //no hace nada si es nulo
        }
    Clients clientExists = search(deletedClient.getId());
    
    if (clientExists != null) {
        listC.remove(clientExists); 
        return true;
    }   
return false;
}
//------------BUSCAR  
    @Override
    public Clients search(Object id) {
    if (id instanceof Integer clientId) { // Conversión segura a Integer
        for (Clients client : listC) {
            if (client.getId() == clientId) {
                return client;
            }
        }
    }
    return null;
}
    

    }//------------FINAL LINEA
