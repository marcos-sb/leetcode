class Solution {
    public String reverseWords(String s) {
        final var chars = s.toCharArray();
        final var n = trim(chars);
        if (n == 0) return "";

        reverse(chars, 0, n - 1);

        var start = 0;
        for (var end = 0; end <= n; ++end) {
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        return new String(chars, 0, n);  // Use the trimmed length
    }

    private static int trim(char[] chars) {
        var i = 0;
        var j = 0;
        var n = chars.length - 1;

        // Skip leading spaces
        while (j < n && chars[j] == ' ') {
            ++j;
        }

        while (j < n && chars[n] == ' ') {
            --n;
        }

        // Adjust n to point to the end
        ++n;

        while (j < n) {
            // Skip multiple spaces between words
            while (j < n && chars[j] == ' ') {
                ++j;
            }
            // Copy non-space characters
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            // Add single space after word (except for last word)
            if (j < n) {
                chars[i++] = ' ';
            }
        }

        return i;  // new length of the trimmed string
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            final var tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            ++start;
            --end;
        }
    }
}
