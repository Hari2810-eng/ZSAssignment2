import java.util.Scanner;

public class CountAndSay {
    public String countAndSay(String num){
        String result = new String();
        int value=0;
        int number=num.charAt(0)-'0';
        char prev= num.charAt(0); 
        for(char c:num.toCharArray()){
            if(prev!=c){
                result+=(char) (value + '0');
                result+=(char) (number + '0');
                prev = c;
                number = c -'0';
                value=1;
            } else {
                value++;
            }
        }
        result+=(char) (value + '0');
        result+=(char) (number + '0');
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountAndSay c = new CountAndSay();
        
        System.out.print("Enter the String representing the positive Int:");
        String input = sc.next();
        
        System.out.print("Count-and-say sequence result:");
        System.out.println(c.countAndSay(input));
    }
}
