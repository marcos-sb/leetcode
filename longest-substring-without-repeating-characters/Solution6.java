class Solution {
    public int lengthOfLongestSubstring(String s) {
        final var N = s.length();
        final var lastPos = new int[256];
        Arrays.fill(lastPos, -1);
        var l = 0;
        var r = 0;
        var maxLen = 0;
        while (r < N) {
            if (l <= lastPos[(int)s.charAt(r)])
                l = lastPos[(int)s.charAt(r)] + 1;
            lastPos[(int)s.charAt(r)] = r;
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
