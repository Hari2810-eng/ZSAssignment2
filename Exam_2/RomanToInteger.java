import java.util.*;

public class RomanToInteger {
    
    public int romanToValue(String str){
        int n=str.length()-1;
        int preVal =0;
        int total = 0;
        for(int i=n ; i>=0; i--){
            char c = str.charAt(i);
            int value = getValue(c);
            if(value == 0){
                throw new IllegalArgumentException("Illegal roman argument");
            }
            if(preVal <= value)
                total+=value;
            else
                total-=value;
            preVal = value;
        }
        return total;
    }
    public int getValue(char c){
        switch(c){
            case 'I' -> {
                return 1;
            }
            case 'V' -> {
                return 5;
            }
            case 'X' -> {
                return 10;
            }
            case 'L' -> {
                return 50;
            }
            case 'C' -> {
                return 100;
            }
            case 'D' -> {
                return 500;
            }
            case 'M' -> {
                return 1000;
            }
            default -> {
                return 0;
            }
        }
            
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RomanToInteger r = new RomanToInteger();
        System.out.print("Enter the Roman Number:");
        String roman = sc.nextLine();
        
        System.out.print("Integer value to Roman Number: " + r.romanToValue(roman));
    }
}
