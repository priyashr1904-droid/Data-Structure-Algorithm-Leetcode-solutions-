class Solution {
public:
    string intToRoman(int num) {
        vector<pair<int, string>> romanMapping = {
            {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"},
            {100, "C"},  {90, "XC"},  {50, "L"},  {40, "XL"},
            {10, "X"},   {9, "IX"},   {5, "V"},   {4, "IV"},
            {1, "I"}
        };
        
        string result = "";
        
        // Loop through the mapping from largest value to smallest
        for (const auto& [value, symbol] : romanMapping) {
            // While the current value can be subtracted from num
            while (num >= value) {
                result += symbol; // Append the symbol to the result
                num -= value;     // Reduce num by the value
            }
        }
        
        return result;
    }
};