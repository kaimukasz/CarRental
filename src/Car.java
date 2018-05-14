public class Car {
    private String brand;
    private String model;
    private String fuelType;
    private int capacityEngine;
    private int numberOfKilometers;
    private int produceYear;
    private int rentStatus; // 1 - wypożyczona, 0 - wolna

    public Car(String brand, String model, String fuelType, int capacityEngine, int numberOfKilometers, int produceYear, int rentStatus) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.capacityEngine = capacityEngine;
        this.numberOfKilometers = numberOfKilometers;
        this.produceYear = produceYear;
        this.rentStatus = rentStatus;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCapacityEngine() {
        return capacityEngine;
    }

    public void setCapacityEngine(int capacityEngine) {
        this.capacityEngine = capacityEngine;
    }

    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(int numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    public int getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(int rentStatus) {
        this.rentStatus = rentStatus;
    }
}
