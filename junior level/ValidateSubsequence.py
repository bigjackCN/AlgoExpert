"""
Validate Subsequence

Given two non-empty arrays of integers, array and sequence, determine
whether sequence is a subsequence of array.

A subsequence of an array is a set of numbers that appear in the same
order as they appear in the array, but not necessarily consecutively.

Input: [5, 1, 22, 25, 6, -1, 8, 10], [1, 6, -1, 10]

Output: true

"""

# O(n) time | O(1) space
def solution1(array, sequence):
    arrayPointer = 0
    sequencePointer = 0
    while arrayPointer < len(array) and sequencePointer < len(sequence):
        if array[arrayPointer] == sequence[sequencePointer]:
            sequencePointer += 1
        arrayPointer += 1
    return sequencePointer == len(sequence)

# O(n) time | O(1) space
def solution2(array, sequence):
    sequencePointer = 0
    for num in array:
        if sequencePointer < len(sequence) and num == sequence[sequencePointer]:
            sequencePointer += 1
    return sequencePointer == len(sequence)

print(solution1([5, 1, 22, 25, 6, -1, 8, 10], [1, 6, -1, 10]))
print(solution2([5, 1, 22, 25, 6, -1, 8, 10], [1, 6, -1, 10]))
