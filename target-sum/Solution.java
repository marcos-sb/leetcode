class Solution {
    private final Map<Integer, Map<Integer, Integer>> memo;

    public Solution () {
        memo = new HashMap<>();
    }

    public int findTargetSumWays(int[] nums, int target) {
        return bt(nums, 0, -target);
    }

    private int bt(int[] nums, int i, int sumSoFar) {
        if (i == nums.length) {
            return sumSoFar == 0 ? 1 : 0;
        }

        if (memo.containsKey(sumSoFar)) {
            final var sumEntry = memo.get(sumSoFar);
            if (sumEntry.containsKey(i)) return sumEntry.get(i);
        }

        var count = bt(nums, i+1, sumSoFar+nums[i]);
        count += bt(nums, i+1, sumSoFar-nums[i]);

        memo.computeIfAbsent(sumSoFar, k -> new HashMap<>())
            .put(i, count);

        return count;
    }
}
