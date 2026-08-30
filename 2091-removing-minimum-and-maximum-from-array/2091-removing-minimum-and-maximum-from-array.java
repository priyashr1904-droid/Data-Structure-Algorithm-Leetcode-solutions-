class Solution {
    public int minimumDeletions(int[] nums) {
      int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        
        int a = Math.min(minIdx, maxIdx);
        int b = Math.max(minIdx, maxIdx);
        
        int option1 = b + 1;
        int option2 = n - a;
        int option3 = (a + 1) + (n - b);
        
        return Math.min(option1, Math.min(option2, option3));  
    }
}