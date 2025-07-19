class Solution {
    public int lengthOfLongestSubstring(String s) {
        final var n = s.length();
        final var chars = s.toCharArray();

        final var lastSeenPos = new int[256];
        Arrays.fill(lastSeenPos, -1);

        var left = 0;
        var maxLen = 0;
        for (var right = 0; right < n; ++right) {
            final var c = chars[right];
            if (left <= lastSeenPos[c]) {
                left = lastSeenPos[c] + 1;
            }
            lastSeenPos[c] = right;

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
