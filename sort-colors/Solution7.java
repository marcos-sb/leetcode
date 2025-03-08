class Solution {
    private static final Random rnd = new Random();

    public void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length-1);
    }

    private static void quicksort(int[] nums, int lo, int hi) {
        if (hi <= lo) return;

        final var pivot = rnd.nextInt(hi-lo + 1) + lo;
        swap(nums, pivot, hi);

        var k = lo;
        for (var i = lo; i <= hi; i++) {
            if (nums[i] < nums[hi]) swap(nums, k++, i);
        }
        swap(nums, hi, k);

        quicksort(nums, lo, k-1);
        quicksort(nums, k+1, hi);
    }

    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
