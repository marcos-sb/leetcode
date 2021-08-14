class NumArray {
    private final int[] tree;
    private final int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++)
            init(i, nums[i]);
    }
    
    public void update(int index, int val) {
        final var diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }
    
    public int sumRange(int left, int right) {
        return query(right) - query(left-1);
    }
    
    private void init(int i, int val) {
        for (int j = i+1; j < tree.length; j += j&-j)
            tree[j] += val;
    }
    
    private int query(int i) {
        int sum = 0;
        for (int j = i+1; j > 0; j -= j&-j)
            sum += tree[j];
        return sum;
    }
}
