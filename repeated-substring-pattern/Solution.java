class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) return false;
        for (int len = 1; len <= s.length()/2; len++) {
            if (rsp(s, len)) return true;
        }
        return false;
    }

    private static boolean rsp(String s, int len) {
        int k = 0;
        for (int i = len; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(k)) return false;
            k = (k+1) % len;
        }
        return k == 0;
    }
}
