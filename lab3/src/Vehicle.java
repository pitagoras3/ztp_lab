public abstract class Vehicle {

    private int amountOfWheels;
    private String name;
    private String producer;
    private String model;

    public Vehicle(int amountOfWheels, String name, String producer, String model){
        this.amountOfWheels = amountOfWheels;
        this.name = name;
        this.producer = producer;
        this.model = model;
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }
}
