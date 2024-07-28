/*4. Write a Java program that gets a number from the user and displays the name of the weekday. Use enum.*/

import java.util.Scanner;

public class WeekdayName {

    public enum Weekday {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 7 for weekday: ");
        int dayNumber = scanner.nextInt();

        if (dayNumber < 1 || dayNumber > 7) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        } else {
            int index = dayNumber - 1;
            Weekday day = Weekday.values()[index];
            System.out.println("Day of the week: " + day);
        }

    }
}