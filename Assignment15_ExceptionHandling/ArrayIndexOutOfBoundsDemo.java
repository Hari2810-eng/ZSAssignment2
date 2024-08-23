public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int index = 10; 
        
        try {
            if (index < 0 || index >= nums.length) {
                throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            int value = nums[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Execution continues after exception handling.");
    }
}
