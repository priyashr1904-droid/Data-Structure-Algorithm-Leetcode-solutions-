class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char sc = s.charAt(i - 1);
            for (int j = m; j >= 1; j--) {
                if (sc == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m];
    }
}