import java.util.Scanner;

public class PairArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
           
        if(canDivideIntoPairs(nums, n)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean canDivideIntoPairs(int[] nums, int n) {
        if (n%2 != 0)
            return false;
            
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

