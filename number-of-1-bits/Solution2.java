class Solution {

    public int hammingWeight(int n) {
        final var mask = 1;
        var count = 0;
        while (n > 0) {
            if ((n & mask) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
