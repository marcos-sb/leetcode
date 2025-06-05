class Solution {
    public int findKthLargest(int[] nums, int k) {
        final var n = nums.length;
        if (n < k) { return -1; }
        return quickSelect(nums, n-k, 0, n-1);
    }

    private static int quickSelect(int[] nums, int k, int lo, int hi) {
        final var pivotI = ThreadLocalRandom.current().nextInt(lo, hi+1);

        swap(nums, pivotI, hi);

        var j = lo;
        for (var i = lo; i < hi; ++i) {
            if (nums[i] < nums[hi]) {
                swap(nums, i, j);
                ++j;
            }
        }

        swap(nums, j, hi);

        if (k < j) {
            return quickSelect(nums, k, lo, j-1);
        }
        if (j < k) {
            return quickSelect(nums, k, j+1, hi);
        }
        return nums[j];
    }

    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
