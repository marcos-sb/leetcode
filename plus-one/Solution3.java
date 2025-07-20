class Solution {
    public int[] plusOne(int[] digits) {
        final var n = digits.length;
        var carry = 1;
        for (var i = n-1; 0 <= i; --i) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (0 == carry) {
            return digits;
        }

        final var res = new int[n+1];
        res[0] = carry;
        for (var i = 1; i < n+1; ++i) {
            res[i] = digits[i-1];
        }

        return res;
    }
}
