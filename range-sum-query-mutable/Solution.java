class NumArray {
    private final int n;
    private final int[] nums;
    private final int[] fenwick;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.fenwick = new int[n+1];

        for (var i = 0; i < n; ++i) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        var diff = val - nums[index];
        nums[index] = val;
        ++index;

        while(index <= n) {
            fenwick[index] += diff;
            index += index & (-index);
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        var sum = 0;
        ++index;

        while (0 < index) {
            sum += fenwick[index];
            index -= index & (-index);
        }

        return sum;
    }
}
