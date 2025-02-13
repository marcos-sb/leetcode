class Solution {
    public boolean isPalindrome(String s) {
        final var S = s.length();
        var l = 0;
        var r = S-1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (r <= l) return true;
            final var llc = Character.toLowerCase(s.charAt(l));
            final var rlc = Character.toLowerCase(s.charAt(r));
            if (llc != rlc) return false;
            l++; r--;
        }
        return true;
    }
}
