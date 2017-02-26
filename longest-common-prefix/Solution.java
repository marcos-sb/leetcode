public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        final StringBuilder sb = new StringBuilder();
        for(int k = 0; k<strs[0].length(); k++) {
            final char infix = strs[0].charAt(k);
            for(int i = 1; i<strs.length; i++) {
                final String s = strs[i];
                if(k >= s.length() || s.charAt(k) != infix) {
                    return sb.toString();
                }
            }
            sb.append(infix);
        }
        return sb.toString();
    }
}
