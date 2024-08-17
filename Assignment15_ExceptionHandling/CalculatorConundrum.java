class IllegalOperationException extends Exception {
    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) throws IllegalOperationException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        String result;
        switch (operation) {
            case "+":
                result = operand1 + " + " + operand2 + " = " + (operand1 + operand2);
                break;
            case "*":
                result = operand1 + " * " + operand2 + " = " + (operand1 * operand2);
                break;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
                }
                result = operand1 + " / " + operand2 + " = " + (operand1 / operand2);
                break;
            default:
                throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }
        return result;
    }

    public static void main(String[] args) throws IllegalOperationException {
        CalculatorConundrum calculator = new CalculatorConundrum();

        try {
            System.out.println(calculator.calculate(10, 1, "+"));
            System.out.println(calculator.calculate(10, 1, "*"));
            System.out.println(calculator.calculate(10, 1, "/"));
            System.out.println(calculator.calculate(10, 0, "/"));
        } catch (IllegalArgumentException | IllegalOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            calculator.calculate(10, 1, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            calculator.calculate(10, 1, "");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            calculator.calculate(10, 1, "-");
        } catch (IllegalOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
