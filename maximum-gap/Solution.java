class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        final var n = nums.length;
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max == min) return 0;

        final var bucketSize = Math.max(1, (max - min) / (n-1));
        final var bucketCount = (max - min) / bucketSize + 1;
        final var minBuckets = new int[bucketCount];
        final var maxBuckets = new int[bucketCount];
        final var bucketUsed = new boolean[bucketCount];

        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);

        for (var num : nums) {
            final var bucketIdx = (num - min) / bucketSize;
            minBuckets[bucketIdx] = Math.min(minBuckets[bucketIdx], num);
            maxBuckets[bucketIdx] = Math.max(maxBuckets[bucketIdx], num);
            bucketUsed[bucketIdx] = true;
        }

        var maxGap = 0;
        var prevMax = min;
        for (var i = 0; i < bucketCount; ++i) {
            if (!bucketUsed[i]) {
                continue;
            }

            maxGap = Math.max(maxGap, minBuckets[i] - prevMax);
            prevMax = maxBuckets[i];
        }

        return maxGap;
    }
}
