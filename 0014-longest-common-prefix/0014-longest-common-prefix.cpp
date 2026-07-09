class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";
        
        // Step 1: Sort the strings alphabetically
        sort(strs.begin(), strs.end());
        
        // Step 2: Compare the first and last strings
        string first = strs.front();
        string last = strs.back();
        string result = "";
        
        // Match characters sequentially
        for (int i = 0; i < min(first.length(), last.length()); i++) {
            if (first[i] != last[i]) {
                break; // Mismatch found, stop comparing
            }
            result += first[i];
        }
        
        return result;
    }
};