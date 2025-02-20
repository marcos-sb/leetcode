class Solution {
    public int subarraySum(int[] nums, int k) {
        final var N = nums.length;
        final var counts = new HashMap<Integer, Integer>();
        counts.put(0,1);
        var sum = 0;
        var count = 0;
        for (var n : nums) {
            sum += n;
            count += counts.getOrDefault(sum-k, 0);
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
