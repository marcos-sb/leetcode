class Solution {
    public String getSmallestString(int n, int k) {
        final var res = new char[n];
        for (int i = n-1; i >= 0; i--) {
            final var _k = k - i;
            if (_k >= 26) res[i] = 'z';
            else res[i] = (char)('a' + _k-1);
            k -= res[i] - 'a' + 1;
        }
        return new String(res);
    }
}
