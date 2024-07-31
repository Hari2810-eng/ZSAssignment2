/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment10_inheritance;

/**
 *
 * @author priya
 */
class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

class Bike extends Vehicle{
    private boolean hasSidecar;

    // Constructor with 4 parameters
    public Bike(String make, String model, int year, boolean hasSidecar) {
        super(make, model, year);  // Calling parent constructor
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Calling parent method
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }

}

class Car extends Vehicle{
    private int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year);  // Calling parent constructor
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Calling parent method
        System.out.println("Number of Doors: " + numberOfDoors);
    }

}

class Truck extends Vehicle{
    private double payloadCapacity;

    public Truck(String make, String model, int year, double payloadCapacity) {
        super(make, model, year);  // Calling parent constructor
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Calling parent method
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
    }

    public static void main(String[] args) {
        Truck truck = new Truck("Ford", "F-150", 2019, 1.5);
        truck.displayDetails();
    }

}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle myBike = new Bike("Harley Davidson", "Street 750", 2020, true);
        Vehicle myCar = new Car("Toyota", "Camry", 2021, 4);
        Vehicle myTruck = new Truck("Volvo", "FH16", 2019, 25);

        myBike.displayDetails();
        System.out.println();
        
        myCar.displayDetails();
        System.out.println();
        
        myTruck.displayDetails();
    }
}
