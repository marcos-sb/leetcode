class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final var S = s.length();
        final var dp = new boolean[S+1];
        dp[0] = true;
        final var dictSet = new HashSet(wordDict);
        for (var j = 1; j <= S; j++) { // O(S^2) * O(S) => O(S^3)
            for (var i = 0; i < j; i++) {
                // If we couldn't find a substring terminating at 'i' that was present in wordDict before,
                // there's no use in checking if the current 'i' is the start of a substring present
                // in wordDict to keep segmenting the input string.
                if (!dp[i]) continue;
                final var ss = s.substring(i, j); // O(S)
                if (dictSet.contains(ss)) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[S];
    }
}
