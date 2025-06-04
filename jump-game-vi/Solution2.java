class Solution {
    public int maxResult(int[] nums, int k) {
        final var n = nums.length;
        final var dp = new int[n];
        final var maxDeque = new ArrayDeque<Integer>();

        dp[0] = nums[0];
        maxDeque.offer(0);

        for (var i = 1; i < n; ++i) {
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < i - k) {
                maxDeque.pollFirst();
            }

            dp[i] = nums[i] + dp[maxDeque.peekFirst()];

            while (!maxDeque.isEmpty() && dp[maxDeque.peekLast()] <= dp[i]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(i);
        }

        return dp[n-1];
    }
}
