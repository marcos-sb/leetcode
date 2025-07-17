class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        final var s1Chars = s1.toCharArray();
        final var s1Len = s1Chars.length;
        final var counts = new int[26]; // 26 is the alphabet size
        var diffChars = 0;
        for (var c : s1Chars) {
            if (++counts[c-'a'] == 1) {
                ++diffChars;
            }
        }

        final var s2Chars = s2.toCharArray();
        final var s2Len = s2Chars.length;
        var left = 0;
        var right = 0;
        while (right < s2Len) {
            var c = s2Chars[right];
            --counts[c-'a'];
            if (counts[c-'a'] == -1) {
                ++diffChars;
            } else if (counts[c-'a'] == 0) {
                --diffChars;
            }

            if (right-left+1 == s1Len + 1) {
                c = s2Chars[left];
                ++counts[c-'a'];
                if (counts[c-'a'] == 0) {
                    --diffChars;
                } else if (counts[c-'a'] == 1) {
                    ++diffChars;
                }
                ++left;
            }

            if (right-left+1 == s1Len && diffChars == 0) return true;

            ++right;
        }

        return false;
    }
}
