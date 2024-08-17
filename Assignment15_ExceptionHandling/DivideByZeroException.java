import java.util.Scanner;

public class DivideByZeroException{

    public static int divideByZero(int dividend, int divisor){
        return dividend/divisor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the dividend:");
            int dividend = sc.nextInt();
            System.out.print("Enter the divisor:");
            int divisor = sc.nextInt();

            System.out.println(dividend + "/" + divisor + " = " + divideByZero(dividend, divisor));
        }
        catch ( ArithmeticException e){
            System.out.println("Error: Dividing by zero is not allowed");
        } catch ( Exception e){
            System.out.println("Unexpected error has happened");
        } finally {
            sc.close();
        }
    }
}