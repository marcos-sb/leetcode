class Solution {
    public boolean wordPattern(String pattern, String str) {
        final Map<Character, String> pat2word = new HashMap<>();
        final Map<String, Character> word2pat = new HashMap<>();
        
        final var words = str.split("\\s");
        if (pattern.length() != words.length) return false;
        
        for (int i = 0; i < words.length; i++) {
            final var pi = pattern.charAt(i);
            final var word = words[i];
            final var oldWord = pat2word.put(pi, word);
            final var oldPi = word2pat.put(word, pi);
            if (oldWord != null && !oldWord.equals(word)) return false;
            if (oldPi != null && !oldPi.equals(pi)) return false;
        }
        
        return true;
    }
}
