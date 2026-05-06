/*
Question 2: Validate Subsequence

Given two non-empty arrays of integers, array and sequence, determine
whether sequence is a subsequence of array.

A subsequence of an array is a set of numbers that appear in the same
order as they appear in the array, but not necessarily consecutively.


Example:
array = [5, 1, 22, 25, 6, -1, 8, 10]
sequence = [1, 6, -1, 10]

Output: true

Explanation: The numbers 1, 6, -1, and 10 appear in the array in the same
order as in the sequence, so sequence is a valid subsequence of array.

*/

public class ValidateSubsequence {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = new int[]{1, 6, -1, 10};
        System.out.println(solution2(array, sequence));
    }

    // Solution One
    // Iterate through the whole array and check if number in sequence valid
    // O(n) time | O(1) space
    public static boolean solution1(int[] array, int[] sequence) {
        int arrayPointer = 0;
        int sequencePointer = 0;
        while (arrayPointer < array.length && sequencePointer < sequence.length) {
            int arrayNum = array[arrayPointer];
            int sequenceNum = sequence[sequencePointer];
            if (arrayNum == sequenceNum) {
                sequencePointer++;
            }
            arrayPointer++;
        }
        return sequencePointer == sequence.length;
    }

    // Solution Two
    // A similar version using one pointer
    // O(n) time | O(1) space
    public static boolean solution2(int[] array, int[] sequence) {
        int sequencePointer = 0;
        for (int num: array) {
            if (sequencePointer < sequence.length && num == sequence[sequencePointer]) {
                sequencePointer++;
            }
        }
        return sequencePointer == sequence.length;
    }
}