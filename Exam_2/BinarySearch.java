import java.util.Scanner;

public class BinarySearch {
    public int binarySearch(int[] nums, int target){
        int low=0, high =nums.length-1;
        while(low<high){
            int mid = (high+low)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                high = mid-1;
            else 
                low = mid+1;
            
                
        }
        return low+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearch b = new BinarySearch();
        
        System.out.print("Enter the length of the array:");
        int n=sc.nextInt();
        System.out.println("Enter the array elements:");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target element:");
        int t =sc.nextInt();
        System.out.println(b.binarySearch(nums, t));
    }
    
}
