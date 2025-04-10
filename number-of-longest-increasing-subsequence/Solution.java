class Solution {
    public int findNumberOfLIS(int[] nums) {
        final var N = nums.length;
        final var lengths = new int[N];
        final var counts  = new int[N];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        for (var i = 1; i < N; ++i) {
            for (var j = i-1; 0 <= j; --j) {
                if (nums[j] < nums[i]) {
                    if (lengths[i] == lengths[j] + 1) {
                        counts[i] += counts[j];
                    } else if (lengths[i] < lengths[j] + 1) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
        }

        var max = 0;
        for (var len : lengths) {
            max = Math.max(max, len);
        }

        var totalCount = 0;
        for (var i = 0; i < N; ++i) {
            if (lengths[i] == max) totalCount += counts[i];
        }

        return totalCount;
    }
}
