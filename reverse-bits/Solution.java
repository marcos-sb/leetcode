public class Solution {
    public long reverseBits(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>>= 1;
        }
        return res;
    }
}
