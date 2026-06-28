class Solution {
    public String truncateSentence(String s, int k) {
       // Split the sentence into an array of words based on spaces
        String[] words = s.split(" ");
        
        // Join only the first 'k' words back together with a space
        return String.join(" ", java.util.Arrays.copyOfRange(words, 0, k)); 
    }
}