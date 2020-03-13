// Sliding window template
// Two pointers: start & end, valid interval: [start, end)
class Solution {
    public String minWindow(String s, String t) {
        int start, end = 0;
        int count = t.length();
        int min = Integer.MAX_VALUE;
        String res = "";
        // Store each character in t and its frequency
        int[] targetFreq = new int[256];
        initializeTarget(targetFreq, t);
        // Move the start
        for (start = 0; start < s.length(); start++) {
            // Keep moving end until find the first solution
            // Condition: 1) end is not out of bound 2) the substring contains all characters in t
            while (end < s.length() && count > 0) {
                if (targetFreq[s.charAt(end)] > 0) {
                    count--;
                }
                targetFreq[s.charAt(end)]--;
                end++;
            }
            // Handle the possible answer
            if (count == 0) {
                int length = end - start;
                // Update the answer
                if (length < min) {
                    min = length;
                    res = s.substring(start, end);
                }
                // Recover start pinter: 1)recover its frequency 2)if s.charAt(start) is a char in t, recover count
                targetFreq[s.charAt(start)]++;
                if (targetFreq[s.charAt(start)] > 0) {
                    count++;
                }
            }
        }
        return res;
    }
    
    private void initializeTarget(int[] freq, String t) {
        for (char c : t.toCharArray()) {
            freq[c]++; 
        }
    }
}
