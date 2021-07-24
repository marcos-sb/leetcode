public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();

        if (Math.abs(sLen - tLen) > 1) return false;

        final int shorterLen = Math.min(sLen, tLen);
        int diffs = 0;
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) != t.charAt(j)) {
                diffs++;
                if (diffs > 1) return false;
                if (sLen == tLen) {
                    i++; j++;
                } else if (sLen < tLen) {
                    j++;
                } else if (sLen > tLen) {
                    i++;
                }
            } else {
                i++; j++;
            }
        }

        if (i < sLen || j < tLen) diffs++;

        return diffs == 1;
    }
}
