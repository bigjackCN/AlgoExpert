/*
Question 3: Sorted Squared Array

Given a non-empty array of integers that is sorted in ascending order,
return a new array of the squares of each number, also sorted in ascending
order.

The input array may contain negative numbers, and squaring them may
change their order.

Example:
array = [-7, -3, 1, 9, 22]

Output: [1, 9, 49, 81, 484]

Explanation:
After squaring each number in the array, we get [49, 9, 1, 81, 484].
When these values are sorted in ascending order, the result is
[1, 9, 49, 81, 484].

*/

import java.util.Arrays;

public class SortedSquaredArray {
    
    // Solution One
    // Brutal force to first square the number and sort the result
    // O(nlog(n)) time | O(n) space
    public static int[] solution1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 2);      
        }
        Arrays.sort(array);
        return array;
    }

    // Solution Two
    // Use two pointer to fill the number from the bottom to top
    // O(n) time | O(n) space
    public static int[] solution2(int[] array) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        int[] res = new int[array.length];
        int index = array.length - 1;
        while (leftPointer <= rightPointer) {
            int leftValue = Math.abs(array[leftPointer]);
            int rightValue = Math.abs(array[rightPointer]);
            if (leftValue > rightValue) {
                leftPointer++;
                res[index] = leftValue * leftValue;
            } else {
                rightPointer--;
                res[index] = rightValue * rightValue;
            }
            index--;
        }
        return res;
    } 
}