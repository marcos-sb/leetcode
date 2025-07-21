class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        var res = 0;
        final var chars = s.toCharArray();

        for (var word : words) {
            final var wordChars = word.toCharArray();
            if (isSubsequence(chars, wordChars)) {
                ++res;
            }
        }

        return res;
    }

    private static boolean isSubsequence(char[] chars, char[] word) {
        var i = 0;
        var j = 0;

        while (i < chars.length && j < word.length) {
            if (chars[i] == word[j]) {
                ++j;
            }
            ++i;
        }

        return j == word.length;
    }
}
