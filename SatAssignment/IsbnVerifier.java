import java.util.Scanner;

public class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replace("-", "");

        if (stringToVerify.length() != 10) {
            return false;
        }

        int sum = 0;
        int weight = 10;

        for (int i = 0; i < 9; i++) {
            char c = stringToVerify.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += (c - '0') * weight--;
        }

        char lastChar = stringToVerify.charAt(9);
        if (lastChar == 'X') {
            sum += 10;
        } else if (Character.isDigit(lastChar)) {
            sum += (lastChar - '0');
        } else {
            return false;
        }

        return (sum % 11 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IsbnVerifier verifier = new IsbnVerifier();

        System.out.print("Enter an ISBN-10 number to verify: ");
        String input = scanner.nextLine();
        
        boolean isValid = verifier.isValid(input);
        System.out.println("ISBN: " + input + " is valid: " + isValid);
    }
}
