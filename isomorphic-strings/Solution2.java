class Solution {
    public boolean isIsomorphic(String s, String t) {
        final var s2t = new char[256];
        final var t2s = new char[256];
        final var n = s.length();
        final var cs = s.toCharArray();
        final var ct = t.toCharArray();

        for (var i = 0; i < n; ++i) {
            if (s2t[cs[i]] == '\0') {
                s2t[cs[i]] = ct[i];
            }
            if (t2s[ct[i]] == '\0') {
                t2s[ct[i]] = cs[i];
            }
            if (s2t[cs[i]] != ct[i] || t2s[ct[i]] != cs[i]) {
                return false;
            }
        }

        return true;
    }
}
