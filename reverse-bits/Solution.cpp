class Solution {
public:
    unsigned reverseBits(unsigned n) {
        unsigned res {0};
        unsigned mask {1};
        for(int i = 0; i < 32; ++i) {
            res <<= 1;
            res |= (n & mask);
            n >>= 1;
        }

        return res;
    }
};
