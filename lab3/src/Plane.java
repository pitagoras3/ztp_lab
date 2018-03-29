public class Plane extends Vehicle {

    private int amountOfEngines;
    private int maxHeight;

    public Plane(int amountOfWheels, String name, String producer, String model, int amountOfEngines, int maxHeight) {
        super(amountOfWheels, name, producer, model);
        this.amountOfEngines = amountOfEngines;
        this.maxHeight = maxHeight;
    }

    public int getAmountOfEngines() {
        return amountOfEngines;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
