class Solution {
    public String intToRoman(int num) {
        // Hardcode the values and symbols in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Loop through the values array
        for (int i = 0; i < values.length; i++) {
            // While the current Roman value can fit into our remaining number
            while (num >= values[i]) {
                num -= values[i];          // Subtract the value
                roman.append(symbols[i]);  // Append the matching symbol
            }
        }
        
        return roman.toString();
    }
}