class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets where index represents frequency
        // The maximum frequency possible is s.length()
        List<Character>[] buckets = new List[s.length() + 1];
        
        for (char key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // Step 3: Build the result string from the highest bucket to the lowest
        StringBuilder sb = new StringBuilder();
        for (int pos = buckets.length - 1; pos >= 0; pos--) {
            if (buckets[pos] != null) {
                for (char c : buckets[pos]) {
                    // Append the character 'pos' times (its frequency)
                    for (int i = 0; i < pos; i++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}