class Solution {
    public String longestCommonPrefix(String[] strs) {
        var minPrefix = strs[0];
        for (var i = 1; i < strs.length; i++) {
            minPrefix = commonPrefix(minPrefix, strs[i]);
            if (minPrefix == "") break;
        }
        return minPrefix;
    }

    private static String commonPrefix(String s, String t) {
        var i = 0;
        var j = 0;
        var res = new StringBuilder();
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            res.append(s.charAt(i));
            i++; j++;
        }
        return res.toString();
    }
}
