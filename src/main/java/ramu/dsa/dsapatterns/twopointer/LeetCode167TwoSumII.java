package ramu.dsa.dsapatterns.twopointer;

public class LeetCode167TwoSumII {
    public static void main(String[] args) {
        System.out.println("Leet Code 167. Two Sum II - Input Array Is Sorted");
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Target: " + target);
        int[] result = twoSum(numbers, target);
        System.out.println("Two Indices are : " + result[0] + ", " + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Return -1 if no solution is found
    }
}
