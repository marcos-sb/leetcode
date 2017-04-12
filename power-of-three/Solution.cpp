class Solution {
public:
    bool isPowerOfThree(int n) {
        const int max_pow_3_int = 1162261467;
        return n > 0 && max_pow_3_int % n == 0;
    }
};
