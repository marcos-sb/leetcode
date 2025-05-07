class NumArray {
    private final int n;
    private final int[] nums;
    private final int[] fenwick;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.fenwick = new int[n+1];

        for (var i = 0; i < n; ++i) {
            init(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        var diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        var sum = 0;
        for (var i = index + 1; 0 < i; i -= i & -i) {
            sum += fenwick[i];
        }
        return sum;
    }

    private void init(int index, int val) {
        for (var i = index + 1; i <= n; i += i & -i) {
            fenwick[i] += val;
        }
    }
}
