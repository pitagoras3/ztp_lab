package com.marcinkiewicz.vehicles;

public class Airplane extends Vehicle {

    private int maxHeight;

    public Airplane(String vehicleName, Double vehicleLoad) {
        super(vehicleName, vehicleLoad);
    }

    public Airplane(String vehicleName, Double vehicleLoad, int maxHeight) {
        super(vehicleName, vehicleLoad);
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "vehicleName='" + super.getVehicleName() + '\'' +
                ", vehicleLoad=" + super.getVehicleLoad() +
                "maxHeight=" + maxHeight +
                '}';
    }
}
