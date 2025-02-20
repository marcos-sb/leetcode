class Solution {
    public int lengthOfLongestSubstring(String s) {
        var l = 0;
        var r = 0;
        final var seenAt = new HashMap<Character, Integer>();
        var maxLen = 0;
        while (r < s.length()) {
            final var cr = s.charAt(r);
            if (seenAt.containsKey(cr) && l <= seenAt.get(cr)) {
                l = seenAt.get(cr) + 1;
            }
            seenAt.put(cr, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
