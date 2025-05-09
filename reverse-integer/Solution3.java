class Solution {
    public int reverse(int x) {
        var res = 0L;
        while (0 != x) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res < Integer.MIN_VALUE || Integer.MAX_VALUE < res) return 0;
        return (int) res;
    }
}
