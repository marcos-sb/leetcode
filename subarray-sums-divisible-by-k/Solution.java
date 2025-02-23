// (prefix_sum[j] - prefix_sum[i]) % k = 0
// prefix_sum[j] % k = prefix_sum[i] % k
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        final var sumCounts = new HashMap<Integer, Integer>();
        sumCounts.put(0,1);
        var count = 0;
        var sum = 0;
        for (var n : nums) {
            sum = (sum + n) % k;
            if (sum < 0) sum += k;
            count += sumCounts.getOrDefault(sum, 0);
            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
