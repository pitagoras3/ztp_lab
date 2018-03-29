public class Car extends Vehicle {

    private boolean isSteeringWheelOnLeftSide;
    private int amountOfDoors;
    private double engineCapacity;

    public Car(int amountOfWheels, String name, String producer, String model, boolean isSteeringWheelOnLeftSide,
               int amountOfDoors, double engineCapacity){
        super(amountOfWheels, name, producer, model);
        this.isSteeringWheelOnLeftSide = isSteeringWheelOnLeftSide;
        this.amountOfDoors = amountOfDoors;
        this.engineCapacity = engineCapacity;
    }

    public boolean isSteeringWheelOnLeftSide() {
        return isSteeringWheelOnLeftSide;
    }

    public int getAmountOfDoors() {
        return amountOfDoors;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
}
