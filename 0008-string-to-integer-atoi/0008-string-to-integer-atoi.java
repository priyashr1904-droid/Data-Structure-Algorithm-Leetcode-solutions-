class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        int total = 0;

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert characters to integer and handle overflow
        while (i < n) {
            char ch = s.charAt(i);
            // Stop if the character is not a digit
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // Check overflow limits before modifying total
            if (total > Integer.MAX_VALUE / 10 || 
               (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            i++;
        }

        return total * sign;
    }
}