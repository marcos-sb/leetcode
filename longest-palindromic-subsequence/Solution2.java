class Solution {
    public int longestPalindromeSubseq(String s) {
        final var n = s.length();
        var currDp = new int[n];
        var prevDp = new int[n];
        for (var i = n-1; 0 <= i; --i) {
            currDp[i] = 1;
            for (var j = i+1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    currDp[j] = 2 + prevDp[j-1];
                } else {
                    currDp[j] = Math.max(prevDp[j], currDp[j-1]);
                }
            }
            final var tmp = currDp;
            currDp = prevDp;
            prevDp = tmp;
        }
        return prevDp[n-1];
    }
}