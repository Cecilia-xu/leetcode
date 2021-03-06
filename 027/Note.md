# My solution
This solution is the same as the first offical solution.
## Algorithm (Two pointers)
Intuition: Just focus on values which are not equal to val! Copy a new array from index 0 to index i-1.
1. 1st pointer: record the index of the next value which is not equal to val. If we find any element which is not equal to val, assign this number to this position. 
2. 2st pointer: traverse the array
## Pseudocode
```
Input: int[] nums[], int val
Output: int i

int i = 0
for j -> 0 to nums.length - 1 :
  if (nums[j] != val) then nums[i] = nums[j] and i++
  
return i

```
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
# Solution 2
## Algorithm (Two pointers)
Intuition: change the array into a new array with 2 parts: 1)numbers which are not equal to val 2)others<br>
1. 1st pointer: record the searching index of the searching area
2. 2st pointer: record the vaild length of the result
## Pseudocode
```
Input: int[] nums[], int val
Output: int 

int i = 0
int j = nums.length 
while(i < j) then 
  if (nums[i] == val) then nums[i] = nums[j - 1]) and j --
  else i ++
return j
```
## Complexity
- Time complexity: O(n)
- Space complexity: O(1)
