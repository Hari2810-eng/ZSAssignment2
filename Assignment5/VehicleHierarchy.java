
class Vehicle {
    String name;
    String type;

    Vehicle(String name, String type) {
        this.name = name;
        this.type = type;
    }

    void start() {
        System.out.println("The vehicle is starting.");
    }

    void stop() {
        System.out.println("The vehicle is stopping.");
    }

    String getDetails() {
        return "Vehicle Name: " + name + "\nVehicle Type: " + type;
    }
}

class Car extends Vehicle {
    Car(String name) {
        super(name, "Car");
    }

    @Override
    void start() {
        System.out.println("The car is starting.");
    }

    @Override
    void stop() {
        System.out.println("The car is stopping.");
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name, "Bike");
    }

    @Override
    void start() {
        System.out.println("The bike is starting.");
    }

    @Override
    void stop() {
        System.out.println("The bike is stopping.");
    }
}

public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bike("Harley");

        vehicle(car);
        vehicle(bike);
    }

    public static void vehicle(Vehicle vehicle) {
        System.out.println(vehicle.getDetails());
        vehicle.start();
        vehicle.stop();
        System.out.println();
    }
}
