class Solution {
    public int subarraySum(int[] nums, int k) {
        final var subarrSums = new HashMap<Integer, Integer>();
        
        var count = 0;
        var sum = 0;
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            count += subarrSums.getOrDefault(sum-k, 0);
            subarrSums.put(sum, subarrSums.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}
