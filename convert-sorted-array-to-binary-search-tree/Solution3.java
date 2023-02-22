class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return aux(nums, 0, nums.length-1);
    }

    private static TreeNode aux(int[] nums, int lo, int hi) {
        if (hi < lo) return null;
        final var mid = (hi-lo)/2 + lo;
        final var node = new TreeNode(nums[mid]);
        node.left = aux(nums, lo, mid-1);
        node.right = aux(nums, mid+1, hi);
        return node;
    }
}
