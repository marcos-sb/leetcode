class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        final var map = new HashMap<Character, Integer>();
        var l = 0;
        var r = 0;
        var maxLen = 0;
        while (r < s.length()) {
            final var c = s.charAt(r);
            if (map.containsKey(c)) {
                final var start = map.get(c)+1;
                while (l < start) map.remove(s.charAt(l++));
            }
            map.put(c, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
