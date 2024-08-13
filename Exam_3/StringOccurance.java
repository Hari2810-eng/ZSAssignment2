import java.util.Scanner;

public class StringOccurance {
    public static boolean wordEquals(String s, String word, int index){
        for(int i=index; i<index+word.length(); i++){
            if(s.charAt(i) != word.charAt(i-index))
                return false;
        }
        return true;
    }
    public static int findWord(String s, String word){
        for(int i=0; i<=s.length()-word.length(); i++){
            if(wordEquals(s, word, i))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String s = sc.nextLine();
        System.out.println("Enter the word:");
        String word = sc.nextLine();
        int index = findWord(s, word);
        if(index == -1){
            System.out.println("Word not found");
        } else {
            System.out.println(word + " found at " + index);
        }
    }
    
}
