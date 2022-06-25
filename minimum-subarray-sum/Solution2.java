class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final var N = nums.length;
        final var sum = new int[N];
        sum[0] = nums[0];
        for (var i = 0; i < N-1; i++)
            sum[i+1] = sum[i] + nums[i+1];
        
        if (sum[N-1] < target) return 0;
        
        var min = N;
        for (var i = 0; i < N; i++) {
            final var leftSum = i == 0 ? 0 : sum[i-1];
            var lo = i;
            var hi = N-1;
            while (lo <= hi) {
                final var mid = (hi-lo)/2 + lo;
                if (target <= sum[mid]-leftSum) {
                    hi = mid-1;
                    min = Math.min(min, mid-i+1);
                } else lo = mid+1;
            }
        }
        
        return min;
    }
}
