What is two pointer technique?\
\
The two-pointer technique is a common algorithmic approach used to solve problems that involve arrays or lists. It involves using two pointers (or indices) to traverse the data structure, often from different ends or at different speeds, to achieve a specific goal. This technique is particularly useful for problems related to searching, sorting, and partitioning.\

Problem 1: Leet Code 167 TwoSum II\
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ \
Given an array of integers, find two numbers such that they add up to a specific target number. Return the indices of the two numbers.\
int[] numbers = {2, 7, 11, 15};\
int target = 9;\
Solution:\
To solve this problem using the two-pointer technique, we can follow these steps:
1. Sort the array (if not already sorted).
2. Initialize two pointers: one at the beginning (left) and one at the end (right) of the array.
3. While the left pointer is less than the right pointer:
   - Calculate the sum of the elements at the left and right pointers.
   - If the sum is equal to the target, return the indices of the two numbers.
   - If the sum is less than the target, move the left pointer to the right (left++).
   - If the sum is greater than the target, move the right pointer to the left (right--).
4. If no such pair is found, return an indication that no solution exists (e.g., return an empty array or -1).

Here is a sample implementation in Java:
```java
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
```
