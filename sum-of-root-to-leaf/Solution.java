class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return srtl(root, new StringBuilder());
    }
    
    private static int srtl(TreeNode node, StringBuilder num) {
        if (node == null) return 0;
        num.append(node.val);
        if (isLeaf(node)) {
            final int ret = Integer.parseInt(num.toString(), 2);
            num.setLength(num.length()-1);
            return ret;
        }
        final int sum = srtl(node.left, num) + srtl(node.right, num);
        num.setLength(num.length()-1);
        return sum;
    }
    
    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
