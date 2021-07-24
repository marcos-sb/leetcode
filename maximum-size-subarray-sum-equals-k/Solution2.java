public class Solution2 {
    public int maxSubArrayLen(int[] nums, int k) {
        final Map<Integer, Integer> sum2idx = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) maxLen = Math.max(maxLen, i+1);
            sum2idx.putIfAbsent(sum, i);
            if (sum2idx.containsKey(sum-k))
                maxLen = Math.max(maxLen, i - sum2idx.get(sum-k));
        }
        return maxLen;
    }
}
