import java.util.Scanner;

public class CountVowels {
    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int vowelCount=0;
        
        System.out.println("Enter the String:");
        String str = scanner.nextLine();
        
        str=str.toLowerCase();
        
        for(char c:str.toCharArray()){
            if(isVowel(c))
                vowelCount++;
        }
        System.out.println("No. of vowels in --"+str+"-- : "+vowelCount );
    }

}
