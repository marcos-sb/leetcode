class Solution {
    public int longestPalindrome(String s) {
        final var freqs = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        
        var longest = 0;
        boolean one = false;
        for (var f : freqs.values()) {
            if ((f & 1) == 0) longest += f;
            else {
                longest += f-1;
                one = true;
            }
        }
        
        return one ? longest + 1 : longest;
    }
}
