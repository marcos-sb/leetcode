class Solution {
    public int missingNumber(int[] nums) {
        final var N = nums.length;
        var runningSum = 0;
        for (var n : nums) runningSum += n;
        var expected = N*(N+1)/2;
        return expected - runningSum;
    }
}
