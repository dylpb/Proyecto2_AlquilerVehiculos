
package Vehicles;

import java.time.Year;



public class Vehicle {
   private String plate;   //  P L A CA
    private String brand;
    private String model;
    private int year;
    private VehicleTypeEnum type;  
    private VehicleEnumStade status;
    private double dailyRate;

 public Vehicle(String plate, String brand, String model,double dailyRate, int year, VehicleTypeEnum type, VehicleEnumStade status) throws Exception {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        setYear(year);   // validación incluida en el setter
        setType(type);   // validación incluida en el setter
        setStatus(status); // validación incluida en el setter
    }

 public double getDailtRate(){
     return dailyRate;
 }  
 
    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public VehicleTypeEnum getType() {
        return type;
    }

    public VehicleEnumStade getStatus() {
        return status;
    }

    // Setters con validaciones
    public void setModel(String model) {
        this.model = model;
    }

    public void setDailyRate(double dailyRate){
        this.dailyRate=dailyRate;
    }
    
    public void setYear(int year) throws Exception {
        int currentYear = Year.now().getValue();
        if (year > currentYear) {
            throw new Exception("El año no puede ser mayor al actual.");
        }
        if (currentYear - year > 20) {
            throw new Exception("El vehículo no puede tener más de 20 años de antigüedad.");
        }
        this.year = year;
    }

    public void setType(VehicleTypeEnum type) throws Exception {
        if (type == null) {
            throw new Exception("El tipo de vehículo es inválido.");
        }
        this.type = type;
    }

    public void setStatus(VehicleEnumStade status) throws Exception {
        if (status == null) {
            throw new Exception("El estado del vehículo es inválido.");
        }
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "Vehículo [Placa: " + plate +  ", Marca: " + brand +  ", Modelo: " + model +  ", Año: " + year + ", Tipo: " + type + ", Estado: " + status + "]";        
    }
}