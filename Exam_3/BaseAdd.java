
import java.util.Scanner;
public class BaseAdd {
    public static String addInBase(String num1, String num2, int base) {
        String result = "";
        if(num1.length()< num2.length()) {
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        int carry=0, i=num1.length() -1, j=num2.length() -1;
        while (i>=0 || j>=0 || carry>0) {
            
            int dig1= (i >= 0) ? num1.charAt(i) - '0' : 0;
            int dig2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = dig1 + dig2 + carry;
            carry = sum / base;
            result += sum % base;
            i--;
            j--;
        }
        String reverse = "";
        for(int k=result.length()-1; k>=0; k--){
            reverse+=result.charAt(k);
        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        String num1 = sc.nextLine();
        System.out.println("Enter the second number:");
        String num2 = sc.nextLine();
        System.out.println("Enter the base:");
        int base = sc.nextInt();

        String result = addInBase(num1, num2, base);
        System.out.println(result);
    }
}
