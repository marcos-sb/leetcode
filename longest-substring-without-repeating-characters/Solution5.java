class Solution {
    public int lengthOfLongestSubstring(String s) {
        final var len = s.length();
        if (len == 0) return 0;

        final var inWindow = new int[256];
        var l = 0;
        var r = 0;
        var res = r-l+1;
        while (r < len) {
            final var cr = s.charAt(r);
            if (++inWindow[cr] > 1) {
                do {
                    inWindow[s.charAt(l)]--;
                } while (s.charAt(l++) != cr);
            }
            res = Math.max(res, r-l+1);
            r++;
        }

        return res;
    }
}
