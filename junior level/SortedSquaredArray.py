"""
Sorted Squared Array

Given a non-empty array of integers that is sorted in ascending order,
return a new array of the squares of each number, also sorted in ascending
order.

The input array may contain negative numbers, and squaring them may
change their order.

Input: [-7, -3, 1, 9, 22]

Output: [1, 9, 49, 81, 484]

"""

# O(nlogn) time | O(n) space
def solution1(array):
    sortedSquares = [0 for _ in array]

    for i in range(len(array)):
        num = array[i] * array[i]
        sortedSquares[i] = num
    
    sortedSquares.sort()
    return sortedSquares 

# O(n) time | O(n) space
def solution2(array):
    sortedSquares = [0 for _ in array]

    left = 0
    right = len(array) - 1
    sortedPointer = right
    while left <= right:
        if abs(array[left]) > abs(array[right]):
            sortedSquares[sortedPointer] = array[left] * array[left]
            left += 1
        else:
            sortedSquares[sortedPointer] = array[right] * array[right]
            right -= 1
        sortedPointer -= 1
    
    return sortedSquares

print(solution1([-7, -3, 1, 9, 22]))
print(solution2([-7, -3, 1, 9, 22]))