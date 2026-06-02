class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int maxFreq = 0;
        long totalSum = 0; // Use long to prevent integer overflow during summation
        
        // Step 2: Slide the right pointer across the array
        for (int right = 0; right < nums.length; right++) {
            totalSum += nums[right];
            
            // Current window size
            long windowLength = right - left + 1;
            
            // If operations required exceed k, shrink the window from the left
            while ((long) nums[right] * windowLength - totalSum > k) {
                totalSum -= nums[left];
                left++;
                windowLength = right - left + 1; // Update window length after shrinking
            }
            
            // Track the maximum valid window size found
            maxFreq = Math.max(maxFreq, (int) windowLength);
        }
        
        return maxFreq;
    }
}