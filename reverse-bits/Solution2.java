public class Solution {
    public int reverseBits(int n) {
        var res = 0;
        var i = 0;
        while (i < 32 && 0 != n) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
            ++i;
        }
        return res << (32 - i);
    }
}
