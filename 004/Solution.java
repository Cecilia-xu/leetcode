// Solution: binary search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (n1 + n2 + 1) / 2;
        int left = 0, right = n1 - 1;
        while (left <= right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                left = m1 + 1;
            }
            else {
                right = m1 - 1;
            }
        }
        
        int m1 = left;
        int m2 = k - left;
        
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], 
                          m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], 
                          m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        
        if ((n1 + n2) % 2 == 1) {
            return (double)c1;
        }
        else {
            return (double)(c1 + c2) / 2;
        }
    }
}
