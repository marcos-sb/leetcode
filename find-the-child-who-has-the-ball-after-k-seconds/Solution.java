class Solution {
    public int numberOfChild(int n, int k) {
        final var cyclePos = k % (2 * (n-1));
        return Math.min(cyclePos, 2 * (n-1) - cyclePos);
    }
}
