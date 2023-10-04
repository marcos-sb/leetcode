class Solution {
    public int singleNonDuplicate(int[] nums) {
        final var N = nums.length;
        if (N == 1) return nums[0];
        
        var lo = 0;
        var hi = N-1;
        while (lo < hi) { // O(log(N))
            var mid = lo + (hi-lo)/2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid+1]) lo = mid+2;
            else hi = mid;
        }
        return nums[lo];
    }
}
