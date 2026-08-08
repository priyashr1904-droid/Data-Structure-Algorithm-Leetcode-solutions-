class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        int[] ans = new int[m];
        boolean changed = false;
        int i1 = 0;

        for (int idx2 = 0; idx2 < m; idx2++) {
            boolean found = false;
            while (i1 < n) {
                if (word1.charAt(i1) == word2.charAt(idx2)) {
                    ans[idx2] = i1;
                    i1++;
                    found = true;
                    break;
                } else if (!changed && (idx2 == m - 1 || last[idx2 + 1] > i1)) {
                    ans[idx2] = i1;
                    changed = true;
                    i1++;
                    found = true;
                    break;
                }
                i1++;
            }
            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}