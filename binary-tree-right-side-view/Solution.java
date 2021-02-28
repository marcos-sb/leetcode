class Solution {
    private int maxRightDepth = -1;
    
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> l = new ArrayList<>();
        rsv(root, 0, l);
        return l;
    }
    
    private void rsv(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        
        if (maxRightDepth < depth) {
            res.add(node.val);
            maxRightDepth = depth;
        }
        
        rsv(node.right, depth+1, res);
        rsv(node.left, depth+1, res);
    }
}
