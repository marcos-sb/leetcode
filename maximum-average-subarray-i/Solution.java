class Solution {
    public double findMaxAverage(int[] nums, int k) {
        final var N = nums.length;
        var sum = 0d;
        var i = 0;
        while (i < k) sum += nums[i++];
        var maxAvg = sum / k;
        while (i < N) {
            sum -= nums[i-k];
            sum += nums[i++];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }
}
