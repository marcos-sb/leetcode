class Solution {
    public int reverse(int x) {
        var res = 0;
        while (0 != x) {
            final var digit = x % 10;
            if (Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && 7 < digit )) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && digit < -8)) return 0;
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}
