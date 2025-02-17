class Solution {
    public int numIdenticalPairs(int[] nums) {
        final var counts = new int[101];
        var identicalPairs = 0;
        for (var n : nums) {
            identicalPairs += counts[n]++;
        }
        return identicalPairs;
    }
}
