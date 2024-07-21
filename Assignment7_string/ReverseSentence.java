package com.mycompany.project1;

import java.util.Scanner;

public class ReverseSentence{

    private static String reverseWords(String sentence) {
        char[] charArray = sentence.toCharArray();
        int length = charArray.length;
        int start = 0;

        String result = "";
        String word = "";
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                result = " " + word + result;
                word = "";
            } else {
                word += charArray[i];
            }
        }
        result = word + result;
        return result;
    }
  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence to reverse words: ");
        String sentence = scanner.nextLine();
        String reversedWords = reverseWords(sentence);
        System.out.println("Reversed Words: " + reversedWords);
        scanner.close();
    }

}
