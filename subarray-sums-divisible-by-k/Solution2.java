// (prefix_sum[j] - prefix_sum[i]) % k = 0
// prefix_sum[j] % k = prefix_sum[i] % k
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        final var sumCounts = new int[k];
        sumCounts[0]++;
        var count = 0;
        var sum = 0;
        for (var n : nums) {
            sum = (sum + n) % k;
            if (sum < 0) sum += k;
            count += sumCounts[sum];
            sumCounts[sum]++;
        }
        return count;
    }
}
