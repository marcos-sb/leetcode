class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return aux(nums, 0, nums.length-1);
    }

    private static TreeNode aux(int[] nums, int lo, int hi) {
        if (hi < lo) return null;
        if (lo == hi) return new TreeNode(nums[lo]);
        final var mid = (hi-lo)/2 + lo;
        final var root = new TreeNode(nums[mid]);
        root.left = aux(nums, lo, mid-1);
        root.right = aux(nums, mid+1, hi);
        return root;
    }
}
