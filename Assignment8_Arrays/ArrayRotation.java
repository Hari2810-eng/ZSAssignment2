import java.util.Scanner;

public class ArrayRotation {
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;  
        int[] temp = new int[n];
        
        for (int i = 0; i < k; i++) {
            temp[i] = arr[n - k + i];
        }
        
        for (int i = k; i < n; i++) {
            temp[i] = arr[i - k];
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the number of positions to rotate the array: ");
        int k = scanner.nextInt();
        rotate(arr, k);
        System.out.println("Rotated array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
