class Solution {
    public void rotate(int[] nums, int k) {
        final var n = nums.length;
        final var kmod = k % n;
        if (kmod == 0) return;

        reverse(nums, 0, n-1);
        reverse(nums, 0, kmod-1);
        reverse(nums, kmod, n-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            final var tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}
