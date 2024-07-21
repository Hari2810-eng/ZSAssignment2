import java.util.Scanner;

public class MathOperations {
    private static double pi;
    private static double e;

    static {
        pi = 3.14;
        e = 2.72;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mathematical Operations:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Use pi");
        System.out.println("6. Use e");

        System.out.print("Choose an operation (1-6): ");
        int choice = scanner.nextInt();

        double num1, num2;

        switch (choice) {
            case 1:
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + add(num1, num2));
                break;

            case 2:
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + subtract(num1, num2));
                break;

            case 3:
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + multiply(num1, num2));
                break;

            case 4:
                System.out.print("Enter the first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
                if (num2 != 0) {
                    System.out.println("Result: " + divide(num1, num2));
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;

            case 5:
                System.out.println("Value of pi: " + pi);
                break;

            case 6:
                System.out.println("Value of e: " + e);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
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
}
