package com.marcinkiewicz.vehicles;

public abstract class Vehicle {
    private String vehicleName;
    private Double vehicleLoad;

    public Vehicle(String vehicleName, Double vehicleLoad){
        this.vehicleName = vehicleName;
        this.vehicleLoad = vehicleLoad;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Double getVehicleLoad() {
        return vehicleLoad;
    }

    public void setVehicleLoad(Double vehicleLoad) {
        this.vehicleLoad = vehicleLoad;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleName='" + vehicleName + '\'' +
                ", vehicleLoad=" + vehicleLoad +
                '}';
    }
}
