class NumArray {
    private final int[] cumulativeSum;

    public NumArray(int[] nums) {
        final var N = nums.length;
        cumulativeSum = new int[N+1];
        var sum = 0;
        for (var i = 0; i < N; i++) {
            sum += nums[i];
            cumulativeSum[i+1] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return cumulativeSum[right+1] - cumulativeSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
