class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       Map<Integer, Integer> rowMasks = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
            }
        }

        int count = (n - rowMasks.size()) * 2;

        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        for (int mask : rowMasks.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean right = (mask & rightMask) == 0;
            boolean middle = (mask & middleMask) == 0;

            if (left && right) {
                count += 2;
            } else if (left || right || middle) {
                count += 1;
            }
        }

        return count; 
    }
}