package com.marcinkiewicz.vehicles;

public class Bus extends Vehicle {

    private int maxSpeed;

    public Bus(String vehicleName, Double vehicleLoad) {
        super(vehicleName, vehicleLoad);
    }

    public Bus(String vehicleName, Double vehicleLoad, int maxSpeed) {
        super(vehicleName, vehicleLoad);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "vehicleName='" + super.getVehicleName() + '\'' +
                ", vehicleLoad=" + super.getVehicleLoad() +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}
