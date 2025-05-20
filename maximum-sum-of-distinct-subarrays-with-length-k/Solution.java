class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        final var n = nums.length;
        final var freq = new HashMap<Integer, Integer>();

        var right = 0;
        var sum = 0L;
        var maxSum = 0L;
        while (right < n) {
            final var num = nums[right];
            final var fNum = freq.getOrDefault(num, 0);
            freq.put(num, fNum + 1);
            sum += num;

            if (k <= right+1) {
                if (freq.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }

                final var toRemove = nums[right-k+1];
                final var fRemove = freq.get(toRemove);
                if (fRemove == 1) {
                    freq.remove(toRemove);
                } else {
                    freq.put(toRemove, fRemove-1);
                }
                sum -= toRemove;
            }

            ++right;
        }

        return maxSum;
    }
}
