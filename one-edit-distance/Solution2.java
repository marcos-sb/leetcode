public class Solution2 {
    public boolean isOneEditDistance(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();
        final int shorterLen = Math.min(sLen, tLen);
        int diffs = 0;
        for (int i = 0; i < shorterLen; i++) {
            if (s.charAt(i) != t.charAt(i)) diffs++;
        }

        // change one
        if (sLen == tLen && diffs == 1) return true;

        if (Math.abs(sLen - tLen) != 1) return false;

        // delete one
        if (sLen == tLen + 1) {
            for (int i = 0; i < sLen; i++) {
                final String sDel = s.substring(0,i) + s.substring(i+1,sLen);
                if (sDel.equals(t)) return true;
            }
        }

        // insert one
        if (sLen == tLen - 1) {
            for (int i = 0; i < tLen; i++) {
                final String tDel = t.substring(0,i) + t.substring(i+1,tLen);
                if (tDel.equals(s)) return true;
            }
        }

        return false;
    }
}
