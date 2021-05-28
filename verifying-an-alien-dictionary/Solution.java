class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        final Map<Character, Character> am = alphMapper(order);
        
        return isSorted(words, am);
    }
    
    private static Map<Character, Character> alphMapper(String order) {
        final Map<Character, Character> mapper = new HashMap<>(26);
        for (var i = 0; i < order.length(); i++)
            mapper.put(order.charAt(i), (char)('a'+i));
        return mapper;
    }
    
    private static boolean isSorted(String[] words, Map<Character, Character> am) {
        String prev = words[0];
        for (var i = 1; i < words.length; i++) {
            final String curr = words[i];
            char prevChar = ' ';
            char currChar = ' ';
            
            for (var j = 0; j < prev.length() && j < curr.length(); j++) {
                prevChar = am.get(prev.charAt(j));
                currChar = am.get(curr.charAt(j));
                if (prevChar > currChar) return false;
                if (prevChar < currChar) break;
            }
            
            if (prevChar == currChar && prev.length() > curr.length())
                return false;
            
            prev = curr;
        }
        return true;
    }
}
