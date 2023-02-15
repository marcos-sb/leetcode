class Solution {
    public int characterReplacement(String s, int k) {
        final var len = s.length();
        final var sArr = s.toCharArray();
        final var freqs = new int['Z'-'A'+1];
        var maxFreq = 0;
        var maxLen = 0;
        var l = 0;
        var r = 0;
        while (r < len) {
            maxFreq = Math.max(maxFreq, ++freqs[sArr[r]-'A']);
            if (k < r-l+1-maxFreq) {
                freqs[sArr[l]-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}
