import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface RemoteControlCar{
    void drive();
    int getDistanceTravelled();
}

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{
    private int distanceTravelled;
    private int numberOfVictories=0;
    public void setNumberOfVictories(int victories) {
        this.numberOfVictories = victories;
    }
    public int getNumberOfVictories() {
        return numberOfVictories;
    }
    public void drive(){
        distanceTravelled += 10;
    }
    public int getDistanceTravelled(){
        return distanceTravelled;
    }
    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(otherCar.getNumberOfVictories(), getNumberOfVictories());
    }
}


class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int distanceTravelled =0;
    
    public void drive(){
        distanceTravelled += 20;
    }
    public int getDistanceTravelled(){
        return distanceTravelled;
    }
}


class TestTrack {
    public static void race(RemoteControlCar car) {
        car.drive();
    }
    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        Collections.sort(cars);
        return cars;
    }
}

public class RemoteControllerCarDemo {
    public static void main(String[] args) {
        ProductionRemoteControlCar car1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar car2 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar car3 = new ProductionRemoteControlCar();
        
        car1.setNumberOfVictories(5);
        car2.setNumberOfVictories(10);
        car3.setNumberOfVictories(7);

        List<ProductionRemoteControlCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        System.out.println("Before ranking:");
        for (ProductionRemoteControlCar car : cars) {
            System.out.println("Car with victories: " + car.getNumberOfVictories());
        }
        
        List<ProductionRemoteControlCar> rankedCars = TestTrack.getRankedCars(cars);
        
        System.out.println("\nAfter ranking:");
        for (ProductionRemoteControlCar car : rankedCars) {
            System.out.println("Car with victories: " + car.getNumberOfVictories());
        }
    }
}