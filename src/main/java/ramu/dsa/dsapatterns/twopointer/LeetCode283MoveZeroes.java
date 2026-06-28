package ramu.dsa.dsapatterns.twopointer;

public class LeetCode283MoveZeroes {

    public static void main(String[] args) {
        System.out.println("Leet Code 283. Move Zeroes");
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Input Array: " + java.util.Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output Array: " + java.util.Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left =0;
        int right =0;
        while(right<nums.length){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
