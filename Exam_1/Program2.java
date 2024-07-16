import java.util.Scanner;

public class Program2 {

    static String numToStr(int num) {
        if (num == 0) 
            return "zero";
        String[] ones = new String[]{"","One","Two","Three", "Four", "Five",
                                     "six", "seven", "eight", "nine", "ten",
                                     "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                                     "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String result = "";
        if (num >= 10000000) {
            result+=numToStr(num / 10000000);
            result+="Crore ";
            num %= 10000000;
        }
        if (num >= 100000) {
            result+=numToStr(num / 100000);
            result+="Lakh ";
            num %= 100000;
        }
        if (num >= 1000) {
            result+=numToStr(num / 1000);
            result+="Thousand ";
            num %= 1000;
        }
        if (num >= 100) {
            result+=numToStr(num / 100);
            result+="Hundred And ";
            num %= 100;
        }
        if (num >= 20) {
            result+=tens[num / 10];
            result+=" ";
            num %= 10;
        }
        if (num > 0) {
            result+=ones[num];
            result+=" ";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println(numToStr(num));
    }
}
