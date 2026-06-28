What is two pointer technique?\
\
The two-pointer technique is a common algorithmic approach used to solve problems that involve arrays or lists. It involves using two pointers (or indices) to traverse the data structure, often from different ends or at different speeds, to achieve a specific goal. This technique is particularly useful for problems related to searching, sorting, and partitioning.\

**Pattern 1: Leet Code 167 TwoSum II**\
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ \
Given an array of integers, find two numbers such that they add up to a specific target number. Return the indices of the two numbers.\
int[] numbers = {2, 7, 11, 15};\
int target = 9;\
\
**Solution:**\
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

  \
**Pattern 2: Leet Code 283. Move Zeroes**\
  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. \
  Note that you must do this in-place without making a copy of the array.
  Input: nums = [0,1,0,3,12]\
  Output: [1,3,12,0,0]\
\
  Instead of shifting elements manually (which would take $O(n^2)$ time), we use two pointers that traverse the array together:write_ptr (The slow pointer): Keeps track of the position where the next non-zero element should be placed.read_ptr (The fast pointer): Scans through the array looking for non-zero elements.How it works:As the read_ptr moves across the array, whenever it encounters a non-zero element, it swaps that element with the element at write_ptr.After the swap, write_ptr moves forward by one position.If read_ptr encounters a zero, it simply skips it.\
\
**Solution:**
```java
public static void moveZeroes(int[] nums) {
        int write_ptr = 0; // Slow pointer
        for (int read_ptr = 0; read_ptr < nums.length; read_ptr++) {
            if (nums[read_ptr] != 0) {
                // Swap the elements at write_ptr and read_ptr
                int temp = nums[write_ptr];
                nums[write_ptr] = nums[read_ptr];
                nums[read_ptr] = temp;
                write_ptr++; // Move the slow pointer forward
            }
        }
    }
```