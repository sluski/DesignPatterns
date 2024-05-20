package net.slupski.patterns;

import java.util.function.Consumer;

public class Builder implements Consumer<Integer> {

    @Override
    public void accept(Integer t) {
        Utils.printIndex(t);

        var builder = new CarBuilder();
        builder
                .setBrand("Toyota")
                .setModel("Yaris")
                .setColor("black")
                .setType(CarType.PETROL);

        Car car = builder.build();
        System.out.println(car);
    }

    class CarBuilder {

        private String brand;
        private String model;
        private Float cost;
        private Integer numberOfDoors;
        private String color;
        private CarType type;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setCost(float cost) {
            this.cost = cost;
            return this;
        }

        public CarBuilder setNumberOfDoors(int numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setType(CarType type) {
            this.type = type;
            return this;
        }

        Car build() {
            return new Car(brand, model, cost, numberOfDoors, color, type);
        }
    }

    class Car {

        String brand;
        String model;
        Float cost;
        Integer numberOfDoors;
        String color;
        CarType type;

        public Car(String brand, String model, Float cost, Integer numberOfDoors, String color, CarType type) {
            this.brand = brand;
            this.model = model;
            this.cost = cost;
            this.numberOfDoors = numberOfDoors;
            this.color = color;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Car{" + "brand=" + brand + ", model=" + model + ", cost=" + cost + ", numberOfDoors=" + numberOfDoors + ", color=" + color + ", type=" + type + '}';
        }
    }

    enum CarType {
        ELECTIC,
        PETROL,
        GASOLINE;
    }
}
