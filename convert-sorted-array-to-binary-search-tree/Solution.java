class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null) return null;
    return dfs(nums, 0, nums.length-1);
  }

  private static TreeNode dfs(int[] nums, int lo, int hi) {
    if (hi < lo) return null;
    final var mid = (hi-lo+1)/2 + lo;
    final var newNode = new TreeNode(nums[mid]);
    newNode.left = dfs(nums, lo, mid-1);
    newNode.right = dfs(nums, mid+1, hi);
    return newNode;
  }
}
