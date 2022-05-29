class Solution {
    public int longestPalindrome(String s) {
        final var freqs = new int['z'-'A'+1];
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freqs[c-'A']++;
        }
        
        var longest = 0;
        boolean one = false;
        for (var i = 0; i < freqs.length; i++) {
            final var f = freqs[i];
            if (f == 0) continue;
            if ((f & 1) == 0) longest += f;
            else {
                longest += f-1;
                one = true;
            }
        }
        
        return one ? longest + 1 : longest;
    }
}
