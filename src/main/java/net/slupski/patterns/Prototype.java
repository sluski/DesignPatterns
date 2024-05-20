package net.slupski.patterns;

import java.util.ArrayList;
import java.util.List;

public class Prototype extends Pattern {

    @Override
    void example() {
        List<Vehicle> vehicles = List.of(createCar(), createBus());
        List copies = new ArrayList<Vehicle>();
        vehicles.forEach(vehicle -> copies.add(vehicle.copy()));
        copies.forEach(copy -> System.out.println(copy));
    }

    Vehicle createCar() {
        Car car = new Car();
        car.brand = "Citroen";
        car.model = "C3";
        car.cost = 30000f;
        car.topSpeed = 180;
        return car;

    }

    Vehicle createBus() {
        Bus bus = new Bus();
        bus.brand = "Solaris";
        bus.model = "Urbino";
        bus.cost = 85000f;
        bus.doorsNum = 6;
        return bus;
    }

    abstract class Vehicle {

        String brand;
        String model;
        float cost;

        public Vehicle() {
        }

        Vehicle(Vehicle vehicle) {
            this.brand = vehicle.brand;
            this.model = vehicle.model;
            this.cost = vehicle.cost;
        }

        @Override
        public String toString() {
            return "Vehicle{" + "brand=" + brand + ", model=" + model + ", cost=" + cost + '}';
        }

        abstract Vehicle copy();
    }

    class Car extends Vehicle {

        int topSpeed;

        public Car() {
        }

        Car(Car car) {
            super(car);
            this.topSpeed = car.topSpeed;
        }

        @Override
        public String toString() {
            return "Car{" + "topSpeed=" + topSpeed + "} " + super.toString();
        }

        @Override
        Vehicle copy() {
            return new Car(this);
        }
    }

    class Bus extends Vehicle {

        int doorsNum;

        public Bus() {
        }

        Bus(Bus bus) {
            super(bus);
            this.doorsNum = bus.doorsNum;
        }

        @Override
        public String toString() {
            return "Bus{" + "doorsNum=" + doorsNum + "} " + super.toString();
        }

        @Override
        Vehicle copy() {
            return new Bus(this);
        }

    }

}
