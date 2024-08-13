
import java.util.Scanner;

public class DuplicateZero {
    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;
        
        for (int i= 0; i<n; i++) {
            if(arr[i]== 0) {
                zeros++;
            }
        }
        for(int i= n - 1; i>=0; i--) {
            if(i+zeros < n) {
                arr[i + zeros] = arr[i];
            } 
            if(arr[i] == 0){
                zeros--;
                if (i + zeros < n) {
                    arr[i + zeros] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array size n:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
            duplicateZeros(arr);

        for (int num : arr) 
            System.out.print(num + " ");
    }
}
