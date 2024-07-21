package com.mycompany.project1;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        String reversed = reverse(input);
        System.out.println("Reversed String: " + reversed);
        scanner.close();
    }

    private static String reverse(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }
        return new String(charArray);
    }
}
