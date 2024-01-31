class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        final var N = nums.length;
        return aux(0, N-1, nums);
    }

    private TreeNode aux(int lo, int hi, int[] nums) {
        if (hi < lo) return null;
        final var mid = (hi-lo)/2 + lo;
        final var node = new TreeNode(nums[mid]);
        node.left = aux(lo, mid-1, nums);
        node.right = aux(mid+1, hi, nums);
        return node;
    }
}
