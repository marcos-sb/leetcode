class Solution {
    public int lengthOfLastWord(String s) {
        final var strim = s.trim();
        final var lstIdx = strim.lastIndexOf(' ');
        if (lstIdx < 1) return strim.length();
        return strim.length() - (lstIdx+1);
    }
}
