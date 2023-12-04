class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final var M = text1.length();
        final var N = text2.length();
        var prev = new int[N+1];
        var curr = new int[N+1];
        for (var r = 0; r < M; r++) {
            for (var c = 1; c <= N; c++) {
                if (text1.charAt(r) == text2.charAt(c-1))
                    curr[c] = prev[c-1] + 1;
                else
                    curr[c] = Math.max(curr[c-1], prev[c]);
            }
            final var tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return prev[N];
    }
}
