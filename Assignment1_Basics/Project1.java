/*
5. Write a program that calculates the average weight of 10 people. Use descriptive and meaningful variable names following Java naming conventions. Use proper datatypes for the variables.
*/
import java.util.*;

public class Project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numberOfPeople = 10;
        double totalWeight = 0.0;

        for (int i = 1; i <= numberOfPeople; i++) {
            System.out.print("Enter the weight of person " + i + " : ");
            totalWeight = totalWeight + scanner.nextDouble();
        }
        double averageWeight = totalWeight / numberOfPeople;

        System.out.printf("The average weight: %.3f kg%n", averageWeight);
    }
}
