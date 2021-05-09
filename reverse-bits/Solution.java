public class Solution {
    public long reverseBits(long n) {
        long res = 0;
        int k = 32;
        while (true) {
            res |= n & 1;
            if (--k == 0) break;
            res <<= 1;
            n >>>= 1;
        }

        return res;
    }
}
