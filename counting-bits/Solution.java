class Solution {
    public int[] countBits(int n) {
        final var res = new int[n+1];
        for (var i = 0; i <= n; i++) { // O(n*log2(n))
            res[i] = ones(i);
        }
        return res;
    }

    private static int ones(int n) { // O(log2(n))
        var count = 0;
        while (0 < n) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}
