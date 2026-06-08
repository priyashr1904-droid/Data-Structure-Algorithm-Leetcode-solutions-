class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome, e.g., "racecar" (center is 'e')
            int len1 = expandAroundCenter(s, i, i);
            
            // Case 2: Even length palindrome, e.g., "aabbaa" (center is between 'b' and 'b')
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length found at this center
            int maxLen = Math.max(len1, len2);
            
            // If we found a palindrome longer than our previous best, update our boundaries
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        
        // Return the longest substring using the tracked boundaries
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outward as long as pointers are in bounds and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the valid palindromic substring found
        return right - left - 1;
    }
}