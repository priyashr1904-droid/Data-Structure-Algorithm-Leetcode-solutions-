class Solution {
    public int minMoves(String[] classroom, int energy) {
       int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        if (targetMask == 0) {
            return 0;
        }
        
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy});
        maxEnergy[startR][startC][0] = energy;
        
        int steps = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                if (mask == targetMask) {
                    return steps;
                }
                
                if (e == 0) {
                    continue;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        char ch = classroom[nr].charAt(nc);
                        if (ch == 'X') {
                            continue;
                        }
                        
                        int nextMask = mask;
                        if (ch == 'L') {
                            nextMask |= (1 << litterId[nr][nc]);
                        }
                        
                        int nextEnergy = (ch == 'R') ? energy : e - 1;
                        
                        if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                            maxEnergy[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1; 
    }
}