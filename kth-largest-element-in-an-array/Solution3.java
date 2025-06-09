class Solution {
    public int findKthLargest(int[] nums, int k) {
        final var counts = new int[20002];
        for (var n : nums) {
            ++counts[n+10000];
        }
        for (var i = counts.length-1; 0 <= i; --i) {
            k -= counts[i];
            if (k <= 0) {
                return i-10000;
            }
        }
        return -1;
    }
}
