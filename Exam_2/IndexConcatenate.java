import java.util.Scanner;

public class IndexConcatenate {
    public static void findSubstring(String s, String[] words, int[] result, int[] resultIndex) {
        if (s == null || words == null || words.length == 0) {
            return;
        }
        
        int wordLen = words[0].length();
        int concatLen = wordLen * words.length;
        
        if (s.length() < concatLen) {
            return;
        }
        String[] uniqueWords = new String[words.length];
        int[] wordCount = new int[words.length];
        int uniqueWordCount = 0;
        for (String word : words) {
            int index = indexOf(uniqueWords, word, uniqueWordCount);
            if (index == -1) {
                uniqueWords[uniqueWordCount] = word;
                wordCount[uniqueWordCount] = 1;
                uniqueWordCount++;
            } else {
                wordCount[index]++;
            }
        }
        int indexCounter = 0;
        for (int i = 0; i <= s.length() - concatLen; i++) {
            if (isValidConcatenation(s.substring(i, i + concatLen), wordLen, uniqueWords, wordCount, uniqueWordCount)) {
                if (indexCounter < result.length) {
                    result[indexCounter++] = i;
                }
            }
        }
        resultIndex[0] = indexCounter;
    }

    private static int indexOf(String[] array, String value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] != null && array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValidConcatenation(String s, int wordLen, String[] uniqueWords, int[] wordCount, int uniqueWordCount) {
        int[] seenCount = new int[uniqueWordCount];
        for (int i = 0; i < s.length(); i += wordLen) {
            String word = s.substring(i, i + wordLen);
            int index = indexOf(uniqueWords, word, uniqueWordCount);
            if (index == -1) {
                return false;
            }
            seenCount[index]++;
            if (seenCount[index] > wordCount[index]) {
                return false;
            }
        }
        for (int i = 0; i < uniqueWordCount; i++) {
            if (seenCount[i] != wordCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the input sentence:");
        String s = sc.nextLine();
        System.out.print("Enter the size of words list:");
        int n= sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter the words list:");
        for(int i=0; i<n;i++)
            words[i] =sc.next();
        
        int[] result = new int[100];
        int[] resultIndex = new int[1];
        
        findSubstring(s, words, result, resultIndex);
        
        for (int i = 0; i < resultIndex[0]; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
