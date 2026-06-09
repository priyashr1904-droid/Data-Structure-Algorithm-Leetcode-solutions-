class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();
        
        // Loop through every possible starting position of a substring
        for (int i = 0; i < n; i++) {
            // Frequency array for characters in the current substring starting at i
            int[] freq = new int[26];
            
            // Expand the substring character by character
            for (int j = i; j < n; j++) {
                // Increment the frequency of the current character
                freq[s.charAt(j) - 'a']++;
                
                // Calculate and accumulate the beauty of the substring s[i...j]
                totalBeauty += getBeauty(freq);
            }
        }
        
        return totalBeauty;
    }
    
    // Helper method to find (Max Freq - Min Freq) from the frequency array
    private int getBeauty(int[] freq) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int f : freq) {
            if (f > 0) { // Only consider characters that actually exist in the substring
                max = Math.max(max, f);
                min = Math.min(min, f);
            }
        }
        
        // If max == min (or if no characters exist), beauty is 0
        return (max == Integer.MIN_VALUE) ? 0 : (max - min);
    }
}