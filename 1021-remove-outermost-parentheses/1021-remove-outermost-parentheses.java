class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;
        
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If opened > 0, this '(' is inside a primitive block, so keep it
                if (opened > 0) {
                    result.append(c);
                }
                opened++;
            } else { // c == ')'
                opened--;
                // If opened > 0, this ')' is inside a primitive block, so keep it
                if (opened > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}