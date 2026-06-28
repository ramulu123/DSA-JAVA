# Two Pointer Technique

## What is the Two Pointer Technique?

The **Two Pointer Technique** is a popular algorithmic strategy used to solve problems involving **arrays**, **strings**, and **linked lists** efficiently.

Instead of using nested loops (which often results in **O(n²)** time complexity), this technique uses **two pointers (indices)** that traverse the data structure in a controlled manner.

The pointers may:

- Start from **opposite ends** of the array.
- Start from the **same end** but move at different speeds.
- Move **towards each other** or **in the same direction** depending on the problem.

This approach significantly improves performance for many searching, sorting, partitioning, and comparison problems.

---

## When Should You Use the Two Pointer Technique?

Use the Two Pointer Technique when:

- The input array is **sorted**
- You need to find **pairs or triplets**
- You need to **remove duplicates**
- You need to **partition** an array
- You need to **move elements** while maintaining order
- You need to solve problems in **O(n)** time with **O(1)** extra space

---

# Pattern 1: Opposite Direction Pointers

## LeetCode 167 - Two Sum II (Input Array Is Sorted)

**Problem Link**

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

### Problem Statement

Given a **sorted integer array**, find two numbers such that they add up to a given target.

Return their **1-based indices**.

### Example

```java
numbers = [2, 7, 11, 15]
target = 9

Output:
[1,2]
```

---

## Intuition

Since the array is already sorted:

- The **smallest** value is at the left.
- The **largest** value is at the right.

Compare their sum.

- If the sum is **too small**, move the left pointer to increase the sum.
- If the sum is **too large**, move the right pointer to decrease the sum.
- If the sum equals the target, we've found the answer.

This eliminates unnecessary comparisons.

---

## Algorithm

1. Initialize two pointers:
    - `left = 0`
    - `right = numbers.length - 1`

2. While `left < right`:

    - Calculate the sum.

    - If `sum == target`
        - Return the indices.

    - If `sum < target`
        - Move `left++`.

    - If `sum > target`
        - Move `right--`.

3. If no pair exists, return `[-1, -1]`.

---

## Dry Run

```
numbers = [2,7,11,15]
target = 9

left = 2
right = 15

2 + 15 = 17 > 9
Move right

left = 2
right = 11

2 + 11 = 13 > 9
Move right

left = 2
right = 7

2 + 7 = 9 ✅

Answer = [1,2]
```

---

## Java Solution

```java
public static int[] twoSum(int[] numbers, int target) {

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {

        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return new int[]{left + 1, right + 1};
        }
        else if (sum < target) {
            left++;
        }
        else {
            right--;
        }
    }

    return new int[]{-1, -1};
}
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

---

# Pattern 2: Fast and Slow Pointers (Same Direction)

## LeetCode 283 - Move Zeroes

### Problem Statement

Move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place**.

### Example

```java
Input:
[0,1,0,3,12]

Output:
[1,3,12,0,0]
```

---

## Intuition

Instead of repeatedly shifting elements (which would take **O(n²)** time), maintain two pointers:

### `read_ptr` (Fast Pointer)

- Traverses every element.
- Finds non-zero values.

### `write_ptr` (Slow Pointer)

- Indicates where the next non-zero value should be placed.

Whenever the fast pointer finds a non-zero element:

- Swap it with the element at the slow pointer.
- Move the slow pointer forward.

Zeros automatically accumulate at the end.

---

## Dry Run

```
nums = [0,1,0,3,12]

read = 0
0 -> Skip

read = 1
1 -> Swap with index 0

[1,0,0,3,12]

write = 1

read = 2
0 -> Skip

read = 3
3 -> Swap

[1,3,0,0,12]

write = 2

read = 4
12 -> Swap

[1,3,12,0,0]
```

---

## Java Solution

```java
public static void moveZeroes(int[] nums) {

    int write_ptr = 0;

    for (int read_ptr = 0; read_ptr < nums.length; read_ptr++) {

        if (nums[read_ptr] != 0) {

            int temp = nums[write_ptr];
            nums[write_ptr] = nums[read_ptr];
            nums[read_ptr] = temp;

            write_ptr++;
        }
    }
}
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

---

# 3Sum

> **Difficulty:** Medium  
> **Pattern:** Sorting + Two Pointers  
> **Time Complexity:** O(n²)  
> **Space Complexity:** O(1) (excluding the output list)

---

# Problem Statement

Given an integer array `nums`, return **all unique triplets** `[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The returned solution **must not contain duplicate triplets**.

---

## Constraints

```text
3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
```

---

## Examples

### Example 1

**Input**

```text
nums = [-1,0,1,2,-1,-4]
```

**Output**

```text
[[-1,-1,2],[-1,0,1]]
```

---

### Example 2

**Input**

```text
nums = [0,1,1]
```

**Output**

```text
[]
```

**Explanation**

There is no combination of three numbers whose sum is `0`.

---

### Example 3

**Input**

```text
nums = [0,0,0]
```

**Output**

```text
[[0,0,0]]
```

---

# Understanding the Problem

We need to find **all unique groups of three numbers** whose sum equals **0**.

For example,

```text
nums = [-1,0,1,2,-1,-4]
```

Possible triplets are

```text
[-1,-1,2]
[-1,0,1]
```

Notice that

```text
[-1,0,1]
[0,-1,1]
[1,-1,0]
```

are considered the **same triplet**, so we should return it only once.

---

# Brute Force Approach

Try every possible combination of three numbers.

```text
for i
    for j
        for k
            if sum == 0
```

### Time Complexity

```text
O(n³)
```

This becomes too slow for large arrays.

---

# Optimized Approach

## Pattern Used

# Sorting + Two Pointers

Instead of checking every triplet, we:

1. Sort the array.
2. Fix one number.
3. Find the remaining two numbers using two pointers.

This reduces the complexity from

```text
O(n³)
```

to

```text
O(n²)
```

---

# Why Do We Sort?

Sorting provides several advantages:

- Duplicate numbers become adjacent, making them easy to skip.
- If the current sum is too small, moving the left pointer increases the sum.
- If the current sum is too large, moving the right pointer decreases the sum.
- Enables the efficient Two Pointer technique.

Without sorting, pointer movement would not work correctly.

---

# Intuition

Suppose the sorted array is

```text
[-4,-1,-1,0,1,2]
```

Fix one number.

```text
-1
```

Now we need two numbers whose sum is

```text
1
```

because

```text
-1 + x + y = 0
```

We search for these two numbers using two pointers.

---

# Algorithm

1. Sort the array.
2. Iterate through every element.
3. Treat the current element as the first number.
4. Place:
   - `left = i + 1`
   - `right = n - 1`
5. Calculate

```text
sum = nums[i] + nums[left] + nums[right]
```

- If sum is `0`
  - Store the triplet.
  - Skip duplicate values.
  - Move both pointers.
- If sum is less than `0`
  - Move `left`.
- If sum is greater than `0`
  - Move `right`.
6. Skip duplicate fixed elements.

---

# Visualization

Sorted array

```text
[-4,-1,-1,0,1,2]
```

Fix

```text
      i
      ↓

[-4,-1,-1,0,1,2]
         L     R
```

Current sum

```text
-1 + (-1) + 2 = 0
```

Store

```text
[-1,-1,2]
```

Move both pointers

```text
      i
      ↓

[-4,-1,-1,0,1,2]
            L R
```

Current sum

```text
-1 + 0 + 1 = 0
```

Store

```text
[-1,0,1]
```

---

# Why Skip Duplicates?

Suppose the array is

```text
[-2,-2,0,0,2,2]
```

Without skipping duplicates, we would produce

```text
[-2,0,2]
[-2,0,2]
[-2,0,2]
```

Instead, we skip repeated values:

```java
if (i > 0 && nums[i] == nums[i - 1])
    continue;
```

Similarly,

```java
while(left < right && nums[left] == nums[left + 1])
    left++;

while(left < right && nums[right] == nums[right - 1])
    right--;
```

This guarantees every triplet appears exactly once.

---

# Java Solution

```java
import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

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
```

---

# Dry Run

Input

```text
[-1,0,1,2,-1,-4]
```

After sorting

```text
[-4,-1,-1,0,1,2]
```

### Step 1

Fixed

```text
-4
```

Possible sums

```text
-3
-2
-1
```

No answer.

---

### Step 2

Fixed

```text
-1
```

Pointers

```text
left = -1
right = 2
```

Sum

```text
-1 + -1 + 2 = 0
```

Store

```text
[-1,-1,2]
```

Move pointers.

Next

```text
-1 + 0 + 1 = 0
```

Store

```text
[-1,0,1]
```

---

### Step 3

Next fixed value

```text
-1
```

Duplicate.

Skip it.

---

Final Answer

```text
[[-1,-1,2],[-1,0,1]]
```

---

# Complexity Analysis

| Operation | Complexity |
|-----------|------------|
| Sorting | O(n log n) |
| Outer Loop | O(n) |
| Two Pointer Search | O(n) |
| **Overall** | **O(n²)** |

---

## Space Complexity

```text
O(1)
```

Ignoring the output list.

---

# Edge Cases

### Empty Answer

```text
[1,2,3]
```

Output

```text
[]
```

---

### All Zeros

```text
[0,0,0]
```

Output

```text
[[0,0,0]]
```

---

### Duplicate Numbers

```text
[-2,-2,0,0,2,2]
```

Output

```text
[[-2,0,2]]
```

---

### Already Sorted

```text
[-5,-2,-1,0,3,5]
```

The algorithm still works correctly.

---

# Interview Tips

✅ Sort the array first.

✅ Fix one element and solve the remaining problem using Two Pointers.

✅ Skip duplicate fixed elements.

✅ Skip duplicate left and right values after finding a valid triplet.

✅ Explain why sorting allows pointer movement.

✅ Mention the improvement from **O(n³)** to **O(n²)**.

---

# Pattern Recognition

Use **Sorting + Two Pointers** when:

- The problem asks for pairs or triplets.
- The array can be sorted.
- You need unique combinations.
- The target is a sum.
- You want to reduce nested loops.

---

# Similar Problems

- Two Sum
- Two Sum II (Sorted Array)
- 3Sum Closest
- 4Sum
- Container With Most Water
- Valid Triangle Number

---

# Key Takeaways

- Sorting is the key optimization.
- Two Pointers eliminate the need for a third loop.
- Duplicate skipping ensures unique triplets.
- Overall complexity improves from **O(n³)** to **O(n²)**.
- This is one of the most common interview problems based on the **Sorting + Two Pointers** pattern.
````


# Common Two Pointer Patterns

| Pattern | Pointer Movement | Example Problems |
|----------|------------------|------------------|
| Opposite Ends | Left → Right ← | Two Sum II, Container With Most Water |
| Same Direction | Slow & Fast | Move Zeroes, Remove Duplicates |
| Sliding Window | Expand & Shrink | Longest Substring Without Repeating Characters |
| Partitioning | Both Ends | Sort Colors, Quick Sort Partition |
| Merge | Two Arrays | Merge Sorted Arrays |

---

# Advantages

- Reduces nested loops.
- Improves time complexity from **O(n²)** to **O(n)** in many problems.
- Requires **constant extra space**.
- Easy to implement once the pattern is recognized.
- Frequently asked in coding interviews.

---

# Interview Tips

Before using the Two Pointer Technique, ask yourself:

- Is the array sorted?
- Can two indices solve the problem without extra memory?
- Do I need to compare elements from both ends?
- Can I maintain the answer while traversing only once?
- Can I replace nested loops with two moving pointers?

If the answer to any of these questions is **Yes**, the Two Pointer Technique is likely the right approach.

---

# Related LeetCode Problems

### Easy

- 167. Two Sum II
- 26. Remove Duplicates from Sorted Array
- 27. Remove Element
- 283. Move Zeroes
- 125. Valid Palindrome
- 344. Reverse String

### Medium

- 11. Container With Most Water
- 15. 3Sum
- 16. 3Sum Closest
- 18. 4Sum
- 42. Trapping Rain Water
- 75. Sort Colors

### Hard

- 76. Minimum Window Substring
- 632. Smallest Range Covering Elements from K Lists

---

# Summary

The Two Pointer Technique is one of the most important algorithmic patterns for technical interviews. By strategically moving two indices through a data structure, it allows many problems to be solved in **linear time (O(n))** while using **constant space (O(1))**.

Mastering this pattern will help you solve a wide variety of array, string, and linked list problems efficiently.