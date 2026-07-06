class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            
            
            for (int j = 0; j < currentWord.length(); j++) {
               
                if (currentWord.charAt(j) == x) {
                    result.add(i);
                    break; 
                }
            }
        }
        
        return result;
    }
}