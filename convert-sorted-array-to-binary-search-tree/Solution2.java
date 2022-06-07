class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return aux(nums, 0, nums.length-1);
    }
    
    private static TreeNode aux(int[] nums, int lo, int hi) {
        if (hi < lo) return null;
        if (lo == hi) return new TreeNode(nums[lo]);
        final var mid = (hi-lo)/2 + lo;
        final var ret = new TreeNode(nums[mid]);
        ret.left = aux(nums, lo, mid-1);
        ret.right = aux(nums, mid+1, hi);
        return ret;
    }
}
