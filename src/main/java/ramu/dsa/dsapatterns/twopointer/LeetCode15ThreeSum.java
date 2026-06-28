package ramu.dsa.dsapatterns.twopointer;

public class LeetCode15ThreeSum {

    public static void main(String[] args) {
        System.out.println("Leet Code 15. 3Sum");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input Array: " + java.util.Arrays.toString(nums));
        java.util.List<java.util.List<Integer>> result = threeSum(nums);
        System.out.println("Output Triplets: " + result);
    }

    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
