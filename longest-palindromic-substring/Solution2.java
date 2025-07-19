class Solution {
    public String longestPalindrome(String s) {
        final var n = s.length();
        final var chars = s.toCharArray();
        var start = 0;
        var end = 0;

        for (var i = 0; i < n; ++i) {
            final var len1 = expandAroundCenter(chars, i, i);
            final var len2 = expandAroundCenter(chars, i, i+1);

            final var len = Math.max(len1, len2);

            if (end - start + 1 < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end+1);
    }

    private static int expandAroundCenter(char[] chars, int left, int right) {
        while (0 <= left && right < chars.length && chars[left] == chars[right]) {
            left--; right++;
        }
        return right - left - 1;
    }
}
