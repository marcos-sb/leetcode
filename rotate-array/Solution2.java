class Solution {
    public void rotate(int[] nums, int k) {
        final var n = nums.length;
        final var kmod = k % n;
        if (kmod == 0) return;
        final var res = new int[n];
        var j = 0;
        var i = n-kmod;
        while (j < n) {
            res[j++] = nums[i];
            i = (i + 1) % n;
        }
        i = 0;
        for (var _n : res) {
            nums[i++] = _n;
        }
    }
}
