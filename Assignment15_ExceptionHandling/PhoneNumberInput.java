import java.util.Scanner;
import java.util.InputMismatchException;

public class PhoneNumberInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter the phone number:");
            String input = sc.next();

            if(!isNumeric(input)){
                throw new InputMismatchException("Input is not valid");
            }
            System.out.println("Phone number entered: " + input);
        
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static boolean isNumeric(String number){
        return number != null && number.matches("[0-9]+");
    }
}
