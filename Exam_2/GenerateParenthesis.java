import java.util.Scanner;

public class GenerateParenthesis {
    public void generateParenthesis(int n){
        generateStrings("", 0, 0, n);    
    }
    
    public void generateStrings(String parWord, int openCount, int closeCount, int max){
        if(parWord.length() == max*2 ){
            if( openCount == closeCount )
                System.out.println(parWord);
            parWord = "";
        }
        if(openCount<max)
            generateStrings(parWord+"(", openCount+1, closeCount, max);
        if(closeCount<max && openCount > closeCount)
            generateStrings(parWord+")", openCount, closeCount+1, max);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenerateParenthesis g = new GenerateParenthesis();
        
        System.out.println("Enter the pair of Parenthesis needed: ");
        int max = sc.nextInt();
        g.generateParenthesis(max);
    }
}
