import java.util.*;


public class Program1 {
    static void alterSort(int[] nums){
        int temp;
        for(int i=0; i<nums.length; i+=2){
            for(int j=i+2; j<nums.length; j+=2){
                if(nums[i]<nums[j]){
                    temp = nums[i];
                    nums[i]= nums[j];
                    nums[j] = temp;
                }
            }
        }
        for(int i=1; i<nums.length; i+=2){
            for(int j=i+2; j<nums.length; j+=2){
                if(nums[i]>nums[j]){
                    temp = nums[i];
                    nums[i]= nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length=sc.nextInt();
        
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
            
        }
        alterSort(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] +" ");
            
        }
    }
        
        
}
