class Solution {

    public int[] countBits(int n) {
        final var ans = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            // i has the same number of 1s as i/2 (i >> 1) if i is even (i & 1 == 0), or + 1 if i is odd
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
