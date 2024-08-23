class TempException extends Exception {
    public TempException(String msg) {
        super(msg);
    }
}

public class TempChecker {
    public static void main(String[] args) {
        try {
            checkTemp(-300);
        } catch (TempException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Program continues after handling the custom exception.");
    }

    public static void checkTemp(int t) throws TempException {
        final int MIN = -273;
        final int MAX = 1000;

        if (t < MIN || t > MAX) {
            throw new TempException("Temperature " + t + " is out of range. Valid range is from " + MIN + " to " + MAX + " degrees Celsius.");
        } else {
            System.out.println("Temperature " + t + " is valid.");
        }
    }
}

