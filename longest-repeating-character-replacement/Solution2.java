class Solution {
    public int characterReplacement(String s, int k) {
        final var N = s.length();
        var l = 0;
        var r = 0;
        final var freq = new int['Z'-'A'+1];
        var maxFreq = 0;
        var maxLen = 0;
        while (r < N) {
            maxFreq = Math.max(++freq[s.charAt(r)-'A'], maxFreq);
            if (k < r-l+1-maxFreq) { // <-- this is the key to the problem
                --freq[s.charAt(l)-'A'];
                l++;
            }
            maxLen = Math.max(r-l+1, maxLen);
            r++;
        }
        return maxLen;
    }
}
