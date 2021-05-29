class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        
        int a = 0;
        int b = 1;
        for (int m = 2; m <= n; m++) {
            final var oldB = b;
            b += a;
            a = oldB;
        }
        return b;
    }
}
