class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        aux(root, 0);
        return max;
    }
    
    private int aux(TreeNode root, int sum) {
        if (root == null) return 0;
        
        final var maxSum = Math.max(sum + root.val, root.val);
        final var left = aux(root.left, maxSum);
        final var leftMax = Math.max(left + root.val, root.val);
        var toRight = Math.max(leftMax, maxSum);
        
        final var right = aux(root.right, toRight);
        final var rightMax = Math.max(right + root.val, root.val);
        
        max = Math.max(max, maxSum);
        
        return Math.max(leftMax, rightMax);
    }
}
