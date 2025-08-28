
package Vehicles;

import Vehicles.EnumEstado;
import Vehicles.EnumMarca;
import Vehicles.EnumTipos;
import java.util.HashMap;
import java.util.Map;

public class Vehicle {

        private EnumMarca marca;
        private String modelo;
        private int año;
        private EnumTipos tipo;
        private EnumEstado estado;

    public Vehicle(EnumMarca marca, String modelo, int año, EnumTipos tipo, EnumEstado estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipo = tipo;
        this.estado = estado;
    }

    public EnumMarca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public EnumTipos getTipo() {
        return tipo;
    }

    public EnumEstado getEstado() {
        return estado;
    }

    public void setMarca(EnumMarca marca) {
        this.marca = marca;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTipo(EnumTipos tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EnumEstado estado) {
        this.estado = estado;
    }

    
///Para Actualizar
///
    modelo modeloAC = new modelo();
    modeloAc.setModelo();
    System.out.println("Modelo: " + modeloAc.getModelo());
    tipo tipoAc = new tipo();
    tipoAc.setTipo();
    System.out.println("Tipo: " + tipoAc.getTipo());
    estado estadoAc = new estado();
    estadoAc.setEstado();
    System.out.println("Etado: " + estadoAc.getEstado());
   
}


   

    

}
}
}

    
    
    
