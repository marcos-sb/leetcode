class Solution {
    public boolean isSubsequence(String s, String t) {
        var S = s.length();
        var T = t.length();
        var i = 0;
        var j = 0;
        while (true) {
            if (i == S) return true;
            if (j == T) return false;
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
    }
}
