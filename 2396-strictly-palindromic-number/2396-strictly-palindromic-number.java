class Solution {
    public boolean isStrictlyPalindromic(int n) {
      // The problem statement requires checking bases from 2 up to n - 2
        for (int base = 2; base <= n - 2; base++) {
            
            // 1. Convert n to the current base
            String baseRepresentation = convertToBase(n, base);
            
            // 2. Check if that representation is a palindrome
            if (!isPalindrome(baseRepresentation)) {
                return false; // Fails the test for this base
            }
        }
        
        // If it survives the loop for every single base, it's strictly palindromic
        return true; 
    }

    // ADD THIS: Helper method to convert a number to a specific base string
    private String convertToBase(int n, int base) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            int remainder = n % base;
            result.append(remainder); 
            n = n / base;             
        }
        
        return result.reverse().toString();
    }

    // ADD THIS: Helper method to check if a string reads the same forward and backward
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false; 
            }
            start++;
            end--;
        }
        return true;
    }
}