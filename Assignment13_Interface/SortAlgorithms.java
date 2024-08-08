import java.util.Scanner;

interface Sort{
    void sort(int[] nums);
}

class BubbleSort implements Sort{
    public void sort(int[] nums){
        int n = nums.length;
        int temp=0;
        for(int i=0; i<n-1; i++){
            for(int j=i; j<n; j++){
                if(nums[i]>nums[j]){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}

class InsertionSort implements Sort{
    public void sort(int[] nums){
        for(int i=1; i<nums.length; i++){
            int temp = nums[i];
            int j=i-1;
            while(j>=0 && nums[j] > temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j] = temp;
        }
    }
}
class QuickSort implements Sort{
    public void sort(int[] nums){

    }
}
class MergeSort implements Sort {
    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                i++;
            } else {
                int value = nums[j];
                int index = j;
                
                while (index > i) {
                    nums[index] = nums[index - 1];
                    index--;
                }
                nums[i] = value;
                
                i++;
                mid++;
                j++;
            }
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            
            merge(nums, left, mid, right);
        }
    }

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
}

class SelectionSort implements Sort{
    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
public class SortAlgorithms{
    public static void display(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[]{23, 43, 51, 12, 39};
        Sort s = new MergeSort() ;
        s.sort(nums);
        display(nums);
    }
}