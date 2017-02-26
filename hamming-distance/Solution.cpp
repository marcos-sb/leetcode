class Solution {
public:
    int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        int pos = 1;
        do {
            if ((x & mask) != (y & mask))
                count++;
            mask <<= 1;
        } while (++pos <= 32);

        return count;
    }
};
