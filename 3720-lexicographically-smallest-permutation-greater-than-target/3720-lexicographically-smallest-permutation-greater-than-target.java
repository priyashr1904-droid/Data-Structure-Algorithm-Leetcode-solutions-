class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] totalCount = new int[26];
        for (int i = 0; i < n; i++) {
            totalCount[s.charAt(i) - 'a']++;
        }

        int[] currentCount = totalCount.clone();
        int maxPrefix = 0;
        while (maxPrefix < n) {
            int ch = target.charAt(maxPrefix) - 'a';
            if (currentCount[ch] > 0) {
                currentCount[ch]--;
                maxPrefix++;
            } else {
                break;
            }
        }

        for (int i = Math.min(maxPrefix, n - 1); i >= 0; i--) {
            int[] available = totalCount.clone();
            for (int j = 0; j < i; j++) {
                available[target.charAt(j) - 'a']--;
            }

            int targetChar = target.charAt(i) - 'a';
            int nextChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (available[c] > 0) {
                    nextChar = c;
                    break;
                }
            }

            if (nextChar != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(target, 0, i);
                sb.append((char) ('a' + nextChar));
                available[nextChar]--;

                for (int c = 0; c < 26; c++) {
                    while (available[c] > 0) {
                        sb.append((char) ('a' + c));
                        available[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}