class Solution {
    public int longestSubarray(int[] nums, int limit) {
        final var n = nums.length;
        final var maxQueue = new ArrayDeque<Integer>();
        final var minQueue = new ArrayDeque<Integer>();

        var left = 0;
        var maxLen = 0;
        for (var right = 0; right < n; ++right) {
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(right);

            while (!minQueue.isEmpty() && nums[right] <= nums[minQueue.peekLast()]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(right);

            while (limit < nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()]) {
                if (maxQueue.peekFirst() == left) {
                    maxQueue.pollFirst();
                }
                if (minQueue.peekFirst() == left) {
                    minQueue.pollFirst();
                }
                ++left;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
