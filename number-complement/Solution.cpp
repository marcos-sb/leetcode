class Solution {
public:
    int findComplement(int num) {
        int mask = 1;
        int res = 0;
        unsigned int tmp = num;
        while(tmp) {
            if(!(num & mask)) {
                res |= mask;
            }
            tmp >>= 1;
            mask <<= 1;
        }
        return res;
    }
};
