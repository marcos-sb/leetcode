class Solution {

    public int[] countBits(int n) {
        final var ans = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            var count = 0;
            var _i = i;
            while (_i != 0) {
                if ((_i & 1) == 1) count++;
                _i >>>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}
