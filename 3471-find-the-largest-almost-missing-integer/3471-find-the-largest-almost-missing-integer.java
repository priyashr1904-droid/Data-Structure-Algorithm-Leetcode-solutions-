class Solution {
    public int largestInteger(int[] nums, int k) {
       Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueInWindow = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                uniqueInWindow.add(nums[j]);
            }
            for (int val : uniqueInWindow) {
                countMap.put(val, countMap.getOrDefault(val, 0) + 1);
            }
        }

        int maxAlmostMissing = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                maxAlmostMissing = Math.max(maxAlmostMissing, entry.getKey());
            }
        }

        return maxAlmostMissing; 
    }
}