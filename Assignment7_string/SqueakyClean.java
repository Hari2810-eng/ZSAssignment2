import java.util.*;
public class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            
            switch (c) {
                case '0':
                    result.append('o');
                    break;
                case '1':
                    result.append('l');
                    break;
                case '3':
                    result.append('e');
                    break;
                case '4':
                    result.append('a');
                    break;
                case '5':
                    result.append('s');
                    break;
                case '7':
                    result.append('t');
                    break;
                case ' ':
                    result.append('_');
                    break;
                case '-':
                    if(identifier.charAt(i+1) >= 'a' && identifier.charAt(i+1) <= 'z')
                        result.append((char)(identifier.charAt(++i) -'a' + 'A'));
                    break;
                default:
                    if (Character.isLetter(c)) {
                        result.append(c);
                    }
                    break;
            }
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to clean: ");
        String input = scanner.nextLine();
        
        String cleaned = SqueakyClean.clean(input);
        System.out.println("Result: " + cleaned);
        
    }
}
