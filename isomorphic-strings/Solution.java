class Solution {
    public boolean isIsomorphic(String s, String t) {
        var S = s.length();
        var T = t.length();
        if (S != T) return false;

        var s2t = new char[256];
        var t2s = new char[256];
        for (var i = 0; i < S; i++) {
            var cs = s.charAt(i);
            var ct = t.charAt(i);
            if (s2t[cs] == 0 && t2s[ct] == 0) {
                s2t[cs] = ct;
                t2s[ct] = cs;
            } else if (s2t[cs] != ct || t2s[ct] != cs)
                return false;
        }
        
        return true;
    }
}
