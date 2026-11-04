class Solution {
    public long minOperations(int[] nums, int x, int k) {
       int n = nums.length;
        long[] cost = new long[n + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long sumLeft = 0;
        long sumRight = 0;
        int leftCount = 0;
        int rightCount = 0;

        int targetLeft = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            int in = nums[i];
            if (left.isEmpty() || in <= left.lastKey()) {
                left.put(in, left.getOrDefault(in, 0) + 1);
                sumLeft += in;
                leftCount++;
            } else {
                right.put(in, right.getOrDefault(in, 0) + 1);
                sumRight += in;
                rightCount++;
            }

            if (i >= x) {
                int out = nums[i - x];
                if (left.containsKey(out)) {
                    int c = left.get(out);
                    if (c == 1) left.remove(out);
                    else left.put(out, c - 1);
                    sumLeft -= out;
                    leftCount--;
                } else {
                    int c = right.get(out);
                    if (c == 1) right.remove(out);
                    else right.put(out, c - 1);
                    sumRight -= out;
                    rightCount--;
                }
            }

            while (leftCount > targetLeft) {
                int maxLeft = left.lastKey();
                int c = left.get(maxLeft);
                if (c == 1) left.remove(maxLeft);
                else left.put(maxLeft, c - 1);
                sumLeft -= maxLeft;
                leftCount--;

                right.put(maxLeft, right.getOrDefault(maxLeft, 0) + 1);
                sumRight += maxLeft;
                rightCount++;
            }

            while (leftCount < targetLeft && !right.isEmpty()) {
                int minRight = right.firstKey();
                int c = right.get(minRight);
                if (c == 1) right.remove(minRight);
                else right.put(minRight, c - 1);
                sumRight -= minRight;
                rightCount--;

                left.put(minRight, left.getOrDefault(minRight, 0) + 1);
                sumLeft += minRight;
                leftCount++;
            }

            if (i >= x - 1) {
                long median = left.lastKey();
                cost[i + 1] = (median * leftCount - sumLeft) + (sumRight - median * rightCount);
            }
        }

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, Long.MAX_VALUE / 2);
            for (int i = j * x; i <= n; i++) {
                curr[i] = curr[i - 1];
                if (prev[i - x] != Long.MAX_VALUE / 2) {
                    curr[i] = Math.min(curr[i], prev[i - x] + cost[i]);
                }
            }
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n]; 
    }
}