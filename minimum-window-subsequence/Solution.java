class Solution {
    class MinWindow {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = -1; // This is so that substring returns "" for `s` with no matches
    }
    public String minWindowSeq(String s, String t) {
        final var N = s.length();
        final var M = t.length();
        final var mw = new MinWindow();
        var r = -1;
        var l = -1;
        while (true) {
            var i = l+1;
            var j = 0;
            while (i < N && j < M) {
                if (s.charAt(i) == t.charAt(j)) j++;
                i++;
            }
            if (j < M) break;
            i--; j--;
            r = i;
            while (0 <= i && 0 <= j) {
                if (s.charAt(i) == t.charAt(j)) j--;
                i--;
            }
            i++; j++;
            l = i;
            if (r-l+1 < mw.minLength) {
                mw.minLength = r-l+1;
                mw.left = l;
                mw.right = r;
            }
        }
        return s.substring(mw.left, mw.right+1);
    }
}