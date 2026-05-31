class Solution {
    public String longestCommonPrefix(String[] strs) {
        // To store the result prefix
        StringBuilder ans = new StringBuilder();

        // Sort the array of strings
        Arrays.sort(strs);

        // First string after sorting
        String first = strs[0];

        // Last string after sorting
        String last = strs[strs.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // Stop if characters are different
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            // Add matching character to result
            ans.append(first.charAt(i));
        }

        // Return the final common prefix
        return ans.toString();
    }
}