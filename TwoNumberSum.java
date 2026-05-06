/*

Question 1: Two Number Sum

Given an array of integers nums and an integer target, return the
the two elements such that their sum equals target. You may assume
that exactly one solution exists, and you may not use the same
element twice.

Example:
nums = [2, 7, 11, 15]
target = 9

Output: [2, 7]

Explanation: nums[0] + nums[1] = 2 + 7 = 9
*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {

    // Solution One
    // This is brutal force solution using two for loops
    // O(n^2) time | O(1) space
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int firstNumber = nums[i];
                int secondNumber = nums[j];
                int sum = firstNumber + secondNumber;
                if (sum == target) {
                    return new int[]{firstNumber, secondNumber};
                }
            }
        }
        return new int[]{};
    }

    // Solution Two
    // Using hashmap(dict) to store the value and find the pair
    // O(n) time | O(n) space

    public static int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            Integer pairNumber = map.get(currentNumber);
            if (pairNumber != null) {
                return new int[]{pairNumber, currentNumber};
            }
            map.put(target - currentNumber, currentNumber);
        }
        return new int[]{};
    }

    // Solution Three
    // Using sort and two pointer to find the pair
    // O(nlog(n)) time | O(1) space

    public static int[] solution3(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int firstNumber = nums[left];
            int secondNumber = nums[right];
            int currentSum = firstNumber + secondNumber;
            if (currentSum > target) {
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                return new int[]{firstNumber, secondNumber};
            }
        }
        return new int[]{};
    }
}