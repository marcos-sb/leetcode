class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return aux(nums, 0, nums.length-1);
    }

    private static TreeNode aux(int[] nums, int lo, int hi) {
        if (hi < lo) {
            return null;
        }

        final var n = nums.length;
        var max = nums[lo];
        var maxI = lo;
        for (var i = lo; i <= hi; ++i) {
            final var num = nums[i];
            if (max < num) {
                max = num;
                maxI = i;
            }
        }

        final var left = aux(nums, lo, maxI-1);
        final var right = aux(nums, maxI+1, hi);

        return new TreeNode(max, left, right);
    }
}
