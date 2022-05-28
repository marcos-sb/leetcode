class Solution {
    public int subarraySum(int[] nums, int k) {
        final var freqs = new HashMap<Integer, Integer>();
        var count = 0;
        var sum = 0;
        for (var n : nums) {
            sum += n;
            if (sum == k) count++;
            count += freqs.getOrDefault(sum-k, 0);
            freqs.put(sum, freqs.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
