import java.util.Scanner;

public class FrameMax{
    public static void printSubMax(int[] arr, int k) {
        for(int i = 0; i<= arr.length - k; i++) {
            int max =arr[i]; 
            for(int j= 1; j< k; j++) {
                if (arr[i+j] > max) {
                    max = arr[i+j]; 
                }
            }
            System.out.print(max + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the subarray size k:");
        int k = sc.nextInt();
        System.out.println("Enter the size of the array n:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        printSubMax(arr, k);
        
    }
}
