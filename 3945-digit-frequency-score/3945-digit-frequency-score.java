class Solution {
    public int digitFrequencyScore(int n) {
        int score = 0;
        
        // Handle negative numbers if the problem constraints allow them
        // (Though standard digit problems usually assume non-negative inputs)
        n = Math.abs(n); 
        
        while (n > 0) {
            int digit = n % 10;
            score += digit;
            n /= 10;
        }
        
        return score;
    }
}