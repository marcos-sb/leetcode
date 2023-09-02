class Solution {
    class MinWindow {
        int len = Integer.MAX_VALUE;
        int l = 0;
        int r = -1;
    }
    public String minWindow(String s, String t) {
        final var N = s.length();
        final var M = t.length();
        var l = 0;
        var r = 0;
        final var mw = new MinWindow();
        final var tFreq = new int[256];
        var charRemaining = 0;
        for (var i = 0; i < M; i++)
            if (++tFreq[t.charAt(i)] == 1) charRemaining++;
        while (r < N) {
            if (--tFreq[s.charAt(r)] == 0 && --charRemaining == 0) {
                while (l <= r) {
                    if (r-l+1 < mw.len) {
                        mw.len = r-l+1;
                        mw.l = l;
                        mw.r = r;
                    }
                    if (++tFreq[s.charAt(l++)] == 1) {
                        charRemaining++;
                        break;
                    }
                }
            }
            r++;
        }
        return s.substring(mw.l, mw.r+1);
    }
}

