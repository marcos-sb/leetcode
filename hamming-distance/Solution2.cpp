class Solution2 {
public:
    int hammingDistance(int x, int y) {
        int count = 0;
        int diff = x ^ y;
        int mask = 1;
        while(diff > 0) {
            if(diff & mask) count++;
            diff >>= 1;
        }

        return count;
    }
};
