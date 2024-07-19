public class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public long add(long a, long b) {
        return a + b;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public long subtract(long a, long b) {
        return a - b;
    }

    public float subtract(float a, float b) {
        return a - b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }

    public long divide(long a, long b) {
        return a / b;
    }

    public float divide(float a, float b) {
        return a / b;
    }

    public static void main(String[] args) {
        MathOperations m = new MathOperations();

        System.out.println("Integer Operations:");
        System.out.println("Add: " + m.add(5, 3));
        System.out.println("Subtract: " + m.subtract(5, 3));
        System.out.println("Multiply: " + m.multiply(5, 3));
        System.out.println("Divide: " + m.divide(5, 3));

        System.out.println("\nDouble Operations:");
        System.out.println("Add: " + m.add(5.0, 3.0));
        System.out.println("Subtract: " + m.subtract(5.0, 3.0));
        System.out.println("Multiply: " + m.multiply(5.0, 3.0));
        System.out.println("Divide: " + m .divide(5.0, 3.0));
    }
}
