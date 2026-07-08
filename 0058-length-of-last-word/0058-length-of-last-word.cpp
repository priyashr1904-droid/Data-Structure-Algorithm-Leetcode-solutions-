class Solution {
public:
    int lengthOfLastWord(string s) {
       int length = 0;
        int i = s.length() - 1;

        // Phase 1: Skip any trailing spaces at the end of the string
        while (i >= 0 && s[i] == ' ') {
            i--;
        }

        // Phase 2: Count characters of the last word until a space is found
        while (i >= 0 && s[i] != ' ') {
            length++;
            i--;
        }

        return length; 
    }
};