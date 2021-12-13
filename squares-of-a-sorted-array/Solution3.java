class Solution3 {
    public int[] sortedSquares(int[] nums) {
        final var ret = new int[nums.length];
        var l = 0;
        var r = nums.length-1;
        for (int k = ret.length-1; k >= 0; k--) {
            final var left = nums[l] * nums[l];
            final var right = nums[r] * nums[r];
            if (left > right) {
                ret[k] = left;
                l++;
            } else {
                ret[k] = right;
                r--;
            }
        }
        
        return ret;
    }
}
