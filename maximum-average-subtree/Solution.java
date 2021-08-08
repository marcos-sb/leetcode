class Solution {
    private static double maxSubtreeAvg = Integer.MIN_VALUE;
    
    public double maximumAverageSubtree(TreeNode root) {
        maxSubtreeAvg = Integer.MIN_VALUE;
        mas(root);
        return maxSubtreeAvg;
    }
    
    private static int[] mas(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        
        final var left = mas(root.left);
        final var leftAvg = avg(left);
        final var right = mas(root.right);
        final var rightAvg = avg(right);
        final var node = new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
        final var nodeAvg = avg(node);
        
        maxSubtreeAvg = Math.max(Math.max(Math.max(leftAvg, rightAvg), nodeAvg), maxSubtreeAvg);
        
        return node;
    }
    
    private static double avg(int[] vals) {
        return vals[1] == 0 ? 0d : vals[0] / (double) vals[1];
    }
}
