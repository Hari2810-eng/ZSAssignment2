/*2. Write a program to demonstrate compatible type conversions. For eg., float to int, double to float, int to short*/

public class TypeConvert {

    public static void main(String[] args) {
        byte byteValue = 50;
        short shortValue = byteValue;
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;

        System.out.println("Implicit Conversions:");
        System.out.println("byte: " + byteValue);
        System.out.println("byte to short: " + shortValue);
        System.out.println("short to int: " + intValue);
        System.out.println("int to long: " + longValue);
        System.out.println("long to float: " + floatValue);
        System.out.println("float to double: " + doubleValue);

        double originalDouble = 123.456;
        
        floatValue = (float) originalDouble;
        longValue = (long) floatValue ;
        intValue = (int) longValue;
        shortValue = (short) intValue;
        byteValue = (byte) shortValue;

        System.out.println("\nExplicit Conversions:");
        System.out.println("Double: " + originalDouble);
        System.out.println("double to float: " + floatValue);
        System.out.println("float to long: " + longValue);
        System.out.println("long to int: " + intValue);
        System.out.println("int to short: " + shortValue);
        System.out.println("short to byte: " + byteValue);
    }
}

