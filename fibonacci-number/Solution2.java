class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        var n_2 = 0;
        var n_1 = 1;
        for (var i = 2; i <= n; i++) {
            final var tmp = n_1;
            n_1 += n_2;
            n_2 = tmp;
        }
        return n_1;
    }
}
