import java.util.Scanner;

public class EmailChecker {

  
    private static boolean isValidEmail(String email) {
        int length = email.length();
        int atIndex = -1;

        for (int i = 0; i < length; i++) {
            if (email.charAt(i) == '@') {
                if (atIndex != -1) {
                    return false; // More than one '@'
                }
                atIndex = i;
            }
        }

        if (atIndex == -1 || atIndex == 0 || atIndex == length - 1) {
            return false; // No '@' or '@' is at the start/end
        }

        int dotIndex = -1;
        for (int i = atIndex + 1; i < length; i++) {
            if (email.charAt(i) == '.') {
                dotIndex = i;
                break;
            }
        }

        return dotIndex != -1 && dotIndex < length - 1;
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email address to validate: ");
        String email = scanner.nextLine();
        boolean isValid = isValidEmail(email);
        System.out.println("Email is valid: " + isValid);
        scanner.close();
    }

}
