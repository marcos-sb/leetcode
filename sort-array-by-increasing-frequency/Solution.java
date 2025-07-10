class Solution {
    public int[] frequencySort(int[] nums) {
        final var n = nums.length;
        final var range = 202;
        final var counts = new int[range];
        var maxCount = 0;
        for (var num : nums) {
            maxCount = Math.max(maxCount, ++counts[num+100]);
        }

        final List<Integer>[] buckets = new ArrayList[maxCount+1];
        for (var i = range-1; 0 <= i; --i) {
            final var count = counts[i];
            if (0 == count) continue;
            if (buckets[count] == null)
                buckets[count] = new ArrayList<>();
            buckets[count].add(i-100);
        }

        final var res = new int[n];
        var i = 0;
        for (var count = 1; count < buckets.length; ++count) {
            final var bucket = buckets[count];
            if (bucket == null) continue;
            for (var num : bucket) {
                for (var j = 0; j < count; ++j) {
                    res[i++] = num;
                }
            }
        }

        return res;
    }
}
