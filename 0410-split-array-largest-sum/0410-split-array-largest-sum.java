class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        // Find the boundary for binary search
        for (int num : nums) {
            low = Math.max(low, num); // 'low' is the max single element
            high += num;             // 'high' is the total sum
        }
        
        int ans = high;
        
        // Binary search on the answer space
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(nums, k, mid)) {
                ans = mid;         // mid is a potential answer, save it
                high = mid - 1;    // try to find a smaller maximum sum
            } else {
                low = mid + 1;     // mid is too small, increase the allowed sum
            }
        }
        
        return ans;
    }
    
    // Helper function to check if a max sum of 'maxSum' is feasible with <= k subarrays
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrayCount = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                // Start a new subarray
                subarrayCount++;
                currentSum = num;
                
                // If we need more than k subarrays, this maxSum doesn't work
                if (subarrayCount > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}