import java.util.Scanner;

public class ThresholdRep {
    public static int getCount(int[] arr, int threshold) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / threshold;  
            arr[i] %= threshold;           
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array n:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the threshold value t:");
        int t = sc.nextInt();
        System.out.println(getCount(arr, t));
    }
}

