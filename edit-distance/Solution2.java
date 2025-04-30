class Solution {

    public int minDistance(String word1, String word2) {
        final var m = word1.length();
        final var n = word2.length();

        if (m < n) return minDistance(word2, word1);

        var prevDp = new int[n + 1];
        var currDp = new int[n + 1];
        for (var j = 1; j <= n; ++j) {
            prevDp[j] = j;
        }
        for (var i = 1; i <= m; ++i) {
            currDp[0] = i;
            for (var j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    currDp[j] = prevDp[j - 1];
                } else {
                    currDp[j] =
                        1 +
                        Math.min(
                            Math.min(prevDp[j], currDp[j - 1]),
                            prevDp[j - 1]
                        );
                }
            }
            final var tmp = currDp;
            currDp = prevDp;
            prevDp = tmp;
        }

        return prevDp[n];
    }
}
