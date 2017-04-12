class Solution {
public:
    bool isPowerOfTwo(int n) {
        const int max_pow_2_int = 1 << 30;
        return n > 0 && max_pow_2_int % n == 0;
    }
};
