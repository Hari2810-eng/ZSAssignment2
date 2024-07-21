import java.util.*;

public class Login {
    
    private static String dbusername;
    private static String dbpassword;
    static{
        dbusername="username123";
        dbpassword="password123";
    }
    public static boolean checkCredentials(String username, String password){
        return (dbusername.equals(username) && dbpassword.equals(password));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Username: ");
        String username = sc.nextLine();
        
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        
        if(checkCredentials(username, password)){
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
        
    }
}
