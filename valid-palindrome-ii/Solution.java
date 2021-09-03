class Solution {
    public boolean validPalindrome(String s) {
        var i = 0;
        var j = s.length()-1;
        var diffs = 0;
        return vp(s, i, j, diffs);
    }
    
    private static boolean vp(String s, int i, int j, int diffs) {
        if (diffs > 1) return false;
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) {
            return vp(s, i, j-1, diffs+1) || vp(s, i+1, j, diffs+1);
        }
        return vp(s, i+1, j-1, diffs);
    }
}
