public class Solution {
    /**
     * @param paragraph: 
     * @param banned: 
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        final List<Character> punctL = Arrays.asList('!','?','\'',',',';','.');
        final Set<Character> punct = new HashSet<>();
        for (Character c : punctL) punct.add(c);

        final Set<String> sbanned = new HashSet<>();
        for (String s : banned) sbanned.add(s);

        final Map<String, Integer> freqs = new HashMap<>();
        final String[] words = paragraph.split("\\s+");
        for (String w : words) {
            w = w.toLowerCase();
            if (punct.contains(w.charAt(w.length()-1)))
                w = w.substring(0, w.length()-1);
            else if (w.length() > 1 && w.charAt(w.length()-2) == '\'')
                w = w.substring(0, w.length()-2);
            if (sbanned.contains(w)) continue;

            freqs.put(w, freqs.getOrDefault(w, 0) + 1);
        }

        int maxFreq = 0;
        String maxFreqWord = "";
        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxFreqWord = entry.getKey();
            }
        }

        return maxFreqWord;
    }
}
