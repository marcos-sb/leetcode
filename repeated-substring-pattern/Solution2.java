class Solution {
    public boolean repeatedSubstringPattern(String s) {
        final var S = s.length();
        final var lps = lps(s);
        return 0 < lps[S-1] && S % (S - lps[S-1]) == 0;
    }

    private static int[] lps(String s) {
        final var S = s.length();
        final var lps = new int[S];
        var i = 0;
        for (var j = 1; j < S; j++) {
            while (i > 0 && s.charAt(j) != s.charAt(i)) {
                i = lps[i-1];
            }
            if (s.charAt(j) == s.charAt(i)) i++;
            lps[j] = i;
        }
        return lps;
    }
}
