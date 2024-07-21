import java.util.Scanner;

public class MathOperationsWithConstants {

    private static final double PI;
    private static final double E;

    static {
        PI = 3.14;
        E = 2.72;
    }

    
    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Addition with pi");
        System.out.println("2. Subtraction with e");
        System.out.println("3. Multiplication with pi");
        System.out.println("4. Division by e");
        System.out.println("5. Use pi");
        System.out.println("6. Use e");

        System.out.print("Choose an operation: ");
        int choice = scanner.nextInt();

        double num;

        switch (choice) {
            case 1:
                System.out.print("Enter a number to add with pi: ");
                num = scanner.nextDouble();
                System.out.println("Result: " + add(num, PI));
                break;

            case 2:
                System.out.print("Enter a number to subtract by e: ");
                num = scanner.nextDouble();
                System.out.println("Result: " + subtract(num, E));
                break;

            case 3:
                System.out.print("Enter a number to multiply with pi: ");
                num = scanner.nextDouble();
                System.out.println("Result: " + multiply(num, PI));
                break;

            case 4:
                System.out.print("Enter a number to divide by e: ");
                num = scanner.nextDouble();
                if (E != 0) {
                    System.out.println("Result: " + divide(num, E));
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;

            case 5:
                System.out.println("Value of pi: " + PI);
                break;

            case 6:
                System.out.println("Value of e: " + E);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

    }

}
