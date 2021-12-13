class Solution {
    public int lengthOfLongestSubstring(String s) {
        final var map = new HashMap<Character, Integer>();
        var l = 0;
        var r = 0;
        var maxLen = 0;
        while (r < s.length()) {
            final var c = s.charAt(r);
            if (map.containsKey(c)) l = Math.max(map.get(c)+1, l);
            map.put(c, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
