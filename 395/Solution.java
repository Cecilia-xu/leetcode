// Solution 1: divide and conquer
//
// Time complexity: O(n^2) Worst case: we need to divide after each element, so we need to chack n different parts in O(n) 
// time(traversal). e.g.a4b4c5 k = 5
// Space: O(n) Worst case: the number of recursion call stacks is n
// Note: If we find a letter whose frequent is less than k, then the longest substring should be either on the left side of 
// this letter, or on the right side of the letter.
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        
        int[] freq = new int[26];
        char[] letters = s.toCharArray();
        for (char c : letters) {
            freq[c - 'a']++;
        }
        
        int left = 0, right = s.length();
        for (int i = 0; i < letters.length; i++) {
            if (freq[letters[i] - 'a'] < k) {
                return Math.max(longestSubstring(s.substring(left, i), k), longestSubstring(s.substring(left + 1, right), k));
            }
        }
        
        return s.length();
    }
}

// Solution 2: divide and conquer (improved a lot by using split())
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        
        int[] freq = new int[26];
        char[] letters = s.toCharArray();
        for (char c : letters) {
            freq[c - 'a']++;
        }
        
        int flag = -1;
        for (int i = 0; i < letters.length; i++) {
            if (freq[letters[i] - 'a'] < k) {
                flag = i;
                break;
            }
        }
        
        if (flag == -1) {
            return s.length();
        }
        else {
            String[] subs = s.split(letters[flag] + "");
            int res = Integer.MIN_VALUE;
            for (String sub : subs) {
                res = Math.max(res, longestSubstring(sub, k));
            }
            return res;
        }
    }
}
