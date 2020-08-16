class Solution {
    public int longestPalindrome(String s) {
        final Map<Character, Integer> char2freq = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            char2freq.putIfAbsent(c, 0);
            char2freq.put(c, char2freq.get(c)+1);
        }
        
        int maxLen = 0;
        boolean firstOdd = true;
        for (Integer freq : char2freq.values()) {
            if (freq % 2 == 0) {
                maxLen += freq;
            } else {
                if (firstOdd) {
                    firstOdd = false;
                    maxLen += freq;
                } else {
                    maxLen += freq-1;
                }
            }
        }
        
        return maxLen;
    }
}
