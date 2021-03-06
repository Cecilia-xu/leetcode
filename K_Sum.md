# K Sum Conclusion
### Intuition & Hint
1. Sort the array before using two pointers. See if one of the element is settle, how should we do to solve the sub question?
2. If we need to find the unique cmbination, we should avoid checking the same element. (use a nested while loop/ for loop + *continue*)
3. For some questions, we can use hashmap/hashset to ensure the O(n) time complexity.(v.s. sorting is O(nlogn))
4. If we do not need to find sum == target but to find the count of larger/smaller combinations, we do not need to use two pointers in all cases. (knowing index is enough to count all the results.)
5. If we need to find the closest/lower bound/ upper bound sum of target, two pointer + record the min Math.abs(difference)/min/max
6. Be careful: Is target constant(e.g. 0)/variable(e.g. target)? Does the index we should return start from 0 or 1?/ Is the hash table empty when we want to get something from it?/ Does we combine the same element for the answer? 
7. Pre assumption: When the target does not exist?/ When the length of array is invalid?/ Does the array have duplicate elements?/ Does the result should be unique?(e.g.[2,3,5] & [2,5,3])/ Does the solution only have one available solution?/ return type?(count,boolean,result)/ What should we return when we cannot find the result?
### Questions in LeetCode
- No.001 Two Sum : using hashmap (Notice: when two numbers are the same e.g. 2 + 2 = 4, do we have 2 different 2 in the array?)
- No.167 Two Sum II - Input Array is sorted : using two pointers: sum > target, end--/ sum < target, start++ (Notice: index starts from 1 in this question)
- No.170 Two Sum III - Data Structure design: hashmap is better
- No.653 Two Sum IV - Input is a BST: inorder is sorted array + two pointers
- No.1214 Two Sum BSTs: inorder- two sorted array + two pointers / two sets 
- No.1099 Two Sum: the largest sum less than k - two pointers + update max sum (< k) in the loop
- No.015 3Sum - Let's see we run through all indices of a possible first element of a triplet, and then use two pointers to find the other two elements. (Note: This question is triplet question, which means target is 0)
- No.016 3Sum Closest: Similar to 2Sum cloest. Notice: integer overflow! We should use default min(MAX_VALUE) to store min difference rather than default target. e.g. target = -1, when we calculate the difference, default min - 1 will overflow.
- No.259 3Sum Smaller: Similar to 2Sum larger than target. Use index to calculate combination counts.
- No.018 4Sum: Similar to 3Sum
- No.454 4SumII: Similar to 2Sum
### Other questions
#### Two Sum- unique pairs *deal with duplication*
> **Description**
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

> **Example**
Given nums = [1,1,2,45,46,46], target = 47
return 2
1 + 46 = 47
2 + 45 = 47

```Java
// Solution 1: sorted + two pointers + while loop to deal with duplicate intwo directions
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                count++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        
        return count;
    }
}
```
```Java
// Solution 2: 2 hash set: set1: record answers we have found / set2: record elements we have visited
public static int uniquePairs(int[] nums, int target){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }
```
#### Two Sum - Greater than target   *find the count*
> **Description**
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
> **Example**
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
> Challenge
Do it in O(1) extra space and O(nlogn) time.
```Java
// Solution 1: two pointers
// Sort the array at first.
// If nums[start] + nums[end] > target, it means the number after start + nums[end]. count += end - start
// Else, start++
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                i++;
            }
            else {
                count += j - i;
                j--;
            }
        }
        
        return count;
    }
}
```
#### Two Sum -  Less than or equal to target  *return the result*
```Java
// Solution 1: two pointers
public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                min = Math.min(min, target - nums[left] - nums[right]);
                left++;
            }
            else {
                min = Math.min(min, nums[left] + nums[right] - target);
                right--;
            }
        }
        
        return min;
    }
}
```
#### Two sum - closest to target (Similar question: Leetcode 1099) *return the result*
> **Description**
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
Return the difference between the sum of the two integers and the target.
```Java
// Solution: Sort + two pointers + update min difference in the loop
public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                min = Math.min(min, target - nums[left] - nums[right]);
                left++;
            }
            else {
                min = Math.min(min, nums[left] + nums[right] - target);
                right--;
            }
        }
        
        return min;
    }
}
```
####  Two Sum - Difference equals to target *return the result*
> **Description**
Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
> **Notice**
It's guaranteed there is only one available solution
> **Example**
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)
```Java
// HashMap
// Intuition: A - B = target. 
// If we want to find A in the hash map, we should look for B + target.
// If we want to find B in the hash map, we should look for A - target.
// Notice: return sequence/ index starts from 1
public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.isEmpty() && numsMap.containsKey(nums[i] + target)) {
                return new int[]{i + 1, numsMap.get(nums[i] + target)};
            }
            else if (!numsMap.isEmpty() && numsMap.containsKey(nums[i] - target)) {
                return new int[]{numsMap.get(nums[i] - target), i + 1};
            }
            numsMap.put(nums[i], i + 1);
        }
        
        return new int[]{-1,-1};
    }
}
```
