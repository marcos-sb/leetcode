class Solution {
    public boolean isSubsequence(String s, String t) {
        final var S = s.length();
        final var T = t.length();
        var si = 0;
        var ti = 0;
        while (si < S && ti < T) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }
        return si == S;
    }
}
