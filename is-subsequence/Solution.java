public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length())
            return false;
        int ps = 0; int pt = 0;
        while(ps < s.length() && pt < t.length()) {
            if(s.charAt(ps) == t.charAt(pt))
                ps++;
            pt++;
        }
        return ps == s.length();
    }
}
