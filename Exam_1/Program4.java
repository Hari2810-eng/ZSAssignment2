import java.util.*;

public class Program4 {
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    static int nearestPrime(int num) {
        int i = num;
        while (!isPrime(i)) {
            i++;
        }
        int j = num;
        while (!isPrime(j)) {
            j--;
        }
        if (Math.abs(num - j) <= Math.abs(num - i)) {
            return j;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 23, 35};
        int temp;
        int[] diff = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int prime = nearestPrime(arr[i]);
            diff[i] = Math.abs(arr[i] - prime);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (diff[i] > diff[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = diff[i];
                    diff[i] = diff[j];
                    diff[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
