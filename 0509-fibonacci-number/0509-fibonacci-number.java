class Solution {
    public int fib(int n) {
       if (n <= 1) {
            return n;
        }
        
        int a = 0; // Represents F(n-2)
        int b = 1; // Represents F(n-1)
        int sum = 0;
        
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;   // Move F(n-1) to F(n-2)
            b = sum; // Move current sum to F(n-1)
        }
        
        return sum;
    }
}