class Solution {
    public boolean isPowerOfFour(int num) {
        // 0101 0101 1010 0101 0101 0101 0101 0101
        final int powerOf4Mask = 0x55555555;
        final int powersOf4 = num & powerOf4Mask;
        final int notPowersOf4 = num & ~powerOf4Mask;
        // [1] at least one bit set in a power of 4 position and
        // [2] exactly one bit set and
        // [3] no other bits set
        // 1&2&3 => is power of 4
        return (powersOf4 > 0) && ((powersOf4 & (powersOf4-1)) == 0) && (notPowersOf4 == 0);
    }
}
