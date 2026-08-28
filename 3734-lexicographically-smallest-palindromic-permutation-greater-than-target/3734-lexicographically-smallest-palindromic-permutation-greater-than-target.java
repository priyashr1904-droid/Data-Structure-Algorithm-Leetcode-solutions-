class Solution {
    public String lexPalindromicPermutation(String s, String target) {
      int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int m = n / 2;
        int[] halfCnt = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCnt[i] = freq[i] / 2;
        }

        int[] prefCnt = new int[26];
        int maxPref = 0;
        while (maxPref < m) {
            int c = target.charAt(maxPref) - 'a';
            if (prefCnt[c] + 1 <= halfCnt[c]) {
                prefCnt[c]++;
                maxPref++;
            } else {
                break;
            }
        }

        if (maxPref == m) {
            StringBuilder sb = new StringBuilder();
            sb.append(target, 0, m);
            if (n % 2 == 1) {
                sb.append(midChar);
            }
            for (int i = m - 1; i >= 0; i--) {
                sb.append(target.charAt(i));
            }
            String p0 = sb.toString();
            if (p0.compareTo(target) > 0) {
                return p0;
            }
        }

        int[] curCnt = new int[26];
        for (int i = 0; i < maxPref; i++) {
            curCnt[target.charAt(i) - 'a']++;
        }

        for (int i = maxPref; i >= 0; i--) {
            if (i < m) {
                int targetChar = target.charAt(i) - 'a';
                int chosen = -1;
                for (int c = targetChar + 1; c < 26; c++) {
                    if (halfCnt[c] - curCnt[c] > 0) {
                        chosen = c;
                        break;
                    }
                }

                if (chosen != -1) {
                    char[] h = new char[m];
                    for (int j = 0; j < i; j++) {
                        h[j] = target.charAt(j);
                    }
                    h[i] = (char) ('a' + chosen);

                    int[] rem = new int[26];
                    for (int c = 0; c < 26; c++) {
                        rem[c] = halfCnt[c] - curCnt[c];
                    }
                    rem[chosen]--;

                    int ptr = 0;
                    for (int j = i + 1; j < m; j++) {
                        while (ptr < 26 && rem[ptr] == 0) {
                            ptr++;
                        }
                        h[j] = (char) ('a' + ptr);
                        rem[ptr]--;
                    }

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < m; j++) {
                        sb.append(h[j]);
                    }
                    if (n % 2 == 1) {
                        sb.append(midChar);
                    }
                    for (int j = m - 1; j >= 0; j--) {
                        sb.append(h[j]);
                    }
                    return sb.toString();
                }
            }

            if (i > 0) {
                curCnt[target.charAt(i - 1) - 'a']--;
            }
        }

        return "";  
    }
}