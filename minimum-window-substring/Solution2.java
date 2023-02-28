class Solution {
    public String minWindow(String s, String t) {
        final var sLen = s.length();
        final var tLen = t.length();
        final var remainingWindow = new int[256];
        var remainingCount = 0;
        for (var i = 0; i < tLen; i++)
            if (remainingWindow[t.charAt(i)]++ == 0)
                remainingCount++;

        var l = 0;
        var r = 0;
        var minWindow = new int[]{Integer.MAX_VALUE, 0, -1};
        while (r < sLen) {
            if (--remainingWindow[s.charAt(r)] == 0) remainingCount--;
            while (l <= r && remainingCount == 0) {
                if (++remainingWindow[s.charAt(l)] == 1) {
                    remainingCount++;
                    if (r-l+1 < minWindow[0]) {
                        minWindow[0] = r-l+1;
                        minWindow[1] = l;
                        minWindow[2] = r;
                    }
                }
                l++;
            }
            r++;
        }
        
        return s.substring(minWindow[1], minWindow[2]+1);
    }
}
