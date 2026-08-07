class Solution {
    public String smallestNumber(String num, long t) {
        long tempT = t;
        long t2 = 0, t3 = 0, t5 = 0, t7 = 0;
        
        while (tempT % 2 == 0) { tempT /= 2; t2++; }
        while (tempT % 3 == 0) { tempT /= 3; t3++; }
        while (tempT % 5 == 0) { tempT /= 5; t5++; }
        while (tempT % 7 == 0) { tempT /= 7; t7++; }
        
       
        if (tempT > 1) return "-1";

        int n = num.length();
        int z = n; 
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '0') {
                z = i;
                break;
            }
        }

        
        int[][] factorCount = new int[10][4]; 
        for (int d = 1; d <= 9; d++) {
            int val = d;
            while (val % 2 == 0) { val /= 2; factorCount[d][0]++; }
            while (val % 3 == 0) { val /= 3; factorCount[d][1]++; }
            while (val % 5 == 0) { val /= 5; factorCount[d][2]++; }
            while (val % 7 == 0) { val /= 7; factorCount[d][3]++; }
        }

        
        long[] p2 = new long[n + 1];
        long[] p3 = new long[n + 1];
        long[] p5 = new long[n + 1];
        long[] p7 = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            p2[i + 1] = p2[i] + (d > 0 ? factorCount[d][0] : 0);
            p3[i + 1] = p3[i] + (d > 0 ? factorCount[d][1] : 0);
            p5[i + 1] = p5[i] + (d > 0 ? factorCount[d][2] : 0);
            p7[i + 1] = p7[i] + (d > 0 ? factorCount[d][3] : 0);
        }

        
        if (z == n && p2[n] >= t2 && p3[n] >= t3 && p5[n] >= t5 && p7[n] >= t7) {
            return num;
        }

       
        int maxI = Math.min(z, n - 1);
        for (int i = maxI; i >= 0; i--) {
            int startD = (num.charAt(i) - '0') + 1;
            for (int d = startD; d <= 9; d++) {
                long rem2 = Math.max(0L, t2 - p2[i] - factorCount[d][0]);
                long rem3 = Math.max(0L, t3 - p3[i] - factorCount[d][1]);
                long rem5 = Math.max(0L, t5 - p5[i] - factorCount[d][2]);
                long rem7 = Math.max(0L, t7 - p7[i] - factorCount[d][3]);

                int remLen = n - 1 - i;
                if (minLen(rem2, rem3, rem5, rem7) <= remLen) {
                   
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    
                    
                    fillSuffix(sb, remLen, rem2, rem3, rem5, rem7, factorCount);
                    return sb.toString();
                }
            }
        }

        
        int newLen = Math.max(n + 1, minLen(t2, t3, t5, t7));
        StringBuilder sb = new StringBuilder();
        fillSuffix(sb, newLen, t2, t3, t5, t7, factorCount);
        return sb.toString();
    }

    private int minLen(long p2, long p3, long p5, long p7) {
        long len = p7 + p5 + p3 / 2 + p2 / 3;
        long r3 = p3 % 2;
        long r2 = p2 % 3;

        if (r2 == 1 && r3 == 1) {
            len += 1; 
        } else {
            len += r3 + (r2 > 0 ? 1 : 0);
        }
        return (int) Math.min(len, 1_000_000_000L);
    }

    private void fillSuffix(StringBuilder sb, int len, long r2, long r3, long r5, long r7, int[][] factorCount) {
        for (int k = 0; k < len; k++) {
            for (int d = 1; d <= 9; d++) {
                long nr2 = Math.max(0L, r2 - factorCount[d][0]);
                long nr3 = Math.max(0L, r3 - factorCount[d][1]);
                long nr5 = Math.max(0L, r5 - factorCount[d][2]);
                long nr7 = Math.max(0L, r7 - factorCount[d][3]);

                if (minLen(nr2, nr3, nr5, nr7) <= len - 1 - k) {
                    sb.append(d);
                    r2 = nr2;
                    r3 = nr3;
                    r5 = nr5;
                    r7 = nr7;
                    break;
                }
            }
        }
    }
}