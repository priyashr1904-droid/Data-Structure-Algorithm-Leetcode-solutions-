class Solution {
    public int maxDistinct(String s) {
        HashMap<Character, Integer> unique = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            unique.put(s.charAt(i), 1);
        }
        return unique.size();
        
    }
}