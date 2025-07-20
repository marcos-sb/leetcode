class Solution {
    public String mergeAlternately(String word1, String word2) {
        final var chars1 = word1.toCharArray();
        final var chars2 = word2.toCharArray();
        final var len1 = word1.length();
        final var len2 = word2.length();
        final var shortest = len1 < len2 ? chars1 : chars2;
        final var longest = shortest == chars1 ? chars2 : chars1;
        final var res = new StringBuilder(len1 + len2);

        for (var i = 0; i < shortest.length; ++i) {
            res.append(chars1[i]);
            res.append(chars2[i]);
        }

        for (var i = shortest.length; i < longest.length; ++i) {
            res.append(longest[i]);
        }

        return res.toString();
    }
}
