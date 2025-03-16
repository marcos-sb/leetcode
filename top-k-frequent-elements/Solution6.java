class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var counts = new HashMap<Integer, Integer>();
        for (var n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        final List<Integer>[] buckets = new ArrayList[nums.length+1];
        for (var i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (var e : counts.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        var numCount = 0;
        final var res = new int[k];
        var i = 0;
        outer:
        for (var count = buckets.length-1; 0 <= count; --count) {
            for (var num : buckets[count]) {
                if (k <= numCount) break outer;
                res[i++] = num;
                numCount++;
            }
        }

        return res;
    }
}
