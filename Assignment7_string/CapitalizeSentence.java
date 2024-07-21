import java.util.Scanner;

public class CapitalizeSentence {
    
    private static String capitalizeFirstLetter(String sentence) {
        char[] charArray = sentence.toCharArray();
        int length = charArray.length;

        String result = "";
        boolean capitalize = true;

        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                capitalize = true;
                result += c;
            } else {
                if (capitalize && c >= 'a' && c <= 'z') {
                    result += (char) (c - 'a' + 'A');
                    capitalize = false;
                } else {
                    result += c;
                    capitalize = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence to capitalize each word: ");
        String sentence = scanner.nextLine();
        String capitalized = capitalizeFirstLetter(sentence);
        System.out.println("Capitalized Sentence: " + capitalized);
        scanner.close();
    }
}
