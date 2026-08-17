class Solution {
    public int stoneGameV(int[] stoneValue) {
       int n = stoneValue.length;
        int[][] memo = new int[n][n];
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(prefix, memo, 0, n - 1);
    }

    private int solve(int[] prefix, int[][] memo, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxScore = 0;

        for (int k = i; k < j; k++) {
            int leftSum = prefix[k + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(prefix, memo, i, k));
            } else if (rightSum < leftSum) {
                maxScore = Math.max(maxScore, rightSum + solve(prefix, memo, k + 1, j));
            } else {
                int takeLeft = leftSum + solve(prefix, memo, i, k);
                int takeRight = rightSum + solve(prefix, memo, k + 1, j);
                maxScore = Math.max(maxScore, Math.max(takeLeft, takeRight));
            }
        }

        return memo[i][j] = maxScore; 
    }
}