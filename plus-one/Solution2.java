class Solution {
    public int[] plusOne(int[] digits) {
        final var N = digits.length;
        var carry = 1;
        for (var i = N-1; 0 <= i && 0 < carry; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if (carry == 0) return digits;

        final var res = new int[N+1];
        res[0] = carry;
        System.arraycopy(digits, 0, res, 1, N);
        return res;
    }
}
