class Solution {
    public int scoreOfString(String s) {
        //to get ascii value of char 'ch' in java, we use val=(int)ch
        //to get absolute value of int 'n' in java, we use val=Math.abs(n)
        //to get character from string 's' at index, we use val=s.charAt(i)
        int n = s.length();
        int sum = 0;
        for(int i = 0; i<n-1; i++){
            int a = (int)s.charAt(i);
            int b = (int)s.charAt(i+1);
            sum += Math.abs(a-b);
            
        }
        return sum;  
    }
}