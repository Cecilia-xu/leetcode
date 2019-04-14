# Solution
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        //Important！ Null array!
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j ++) {
            if (nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
```