class Solution {
    public String longestCommonPrefix(String[] strs) {
        final var N = strs.length;
        final var first = strs[0];
        var i = 0;
        outer:
        while (i < first.length()) {
            final var candidate = first.charAt(i);
            for (var word = 1; word < N; word++) {
                if (strs[word].length() <= i || candidate != strs[word].charAt(i)) {
                    break outer;
                }
            }
            i++;
        }
        return first.substring(0, i);
    }
}
