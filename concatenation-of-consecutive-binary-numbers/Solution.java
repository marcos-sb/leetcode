class Solution {
    public int concatenatedBinary(int n) {
        final int mod = 1_000_000_007;
        long res = 0;
        final var st = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) { // O(n * log n)
            int _n = i;
            while (_n > 1) { // O(log _n)
                st.offerLast(_n % 2);
                _n /= 2;
            }
            st.offerLast(_n);
            while (!st.isEmpty()) { // O(log _n) <- log _n elements in st
                res = res * 2 + st.pollLast();
                res %= mod;
            }
        }
        return (int) res;
    }
}
