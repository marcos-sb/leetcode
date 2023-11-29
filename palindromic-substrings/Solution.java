class Solution {
    public int countSubstrings(String s) {
        final var S = s.length();
        var count = 0;
        final var dp = new boolean[S][S];
        for (var i = 0; i < S; i++) dp[i][i] = true;
        count += S;
        for (var i = 0; i < S-1; i++)
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                count++;
            }

        for (var d = 2; d < S; d++) // O(S^2)
            for (var i = 0; i < S-d; i++) {
                final var j = i+d;
                // If the 'core' of the current substring we're considering is a palindrome
                // and the characters are edges are the same, then the current substring is also
                // a palindrome.
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }

        return count;
    }
}
