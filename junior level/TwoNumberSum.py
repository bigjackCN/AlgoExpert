"""
Two Number Sum

Given an array of integers nums and an integer target, return the
the two elements such that their sum equals target. You may assume
that exactly one solution exists, and you may not use the same
element twice.

Input: [2, 7, 11, 15], 9

Output: [2, 7]

"""

# O(n^2) time | O(1) space
def solution1(array, target):
    for i in range(len(array) - 1):
        firstNumber = array[i]
        for j in range(i + 1, len(array)):
            secondNumber = array[j]
            if firstNumber + secondNumber == target:
                return [firstNumber, secondNumber]
    return []

# O(n) time | O(n) space
def solution2(array, target):
    nums = {}
    for num in array:
        if (target - num) in nums:
            return [target - num, num]
        else:
            nums[num] = True
    return []

# O(nlogn) time | O(1) space
def solution3(array, target):
    array.sort()
    left = 0
    right = len(array) - 1
    while left < right:
        sum = array[left] + array[right]
        if sum == target:
            return [array[left], array[right]]
        elif sum > target:
            right -= 1
        else:
            left += 1
    return []

print(solution1([2, 7, 11, 15], 9))
print(solution2([2, 7, 11, 15], 9))
print(solution3([2, 7, 11, 15], 9))
