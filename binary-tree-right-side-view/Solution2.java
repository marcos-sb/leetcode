class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return revInorder(root, 0, new ArrayList<>());
    }
    
    private List<Integer> revInorder(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return res;
        if (res.size() <= depth) res.add(node.val);
        revInorder(node.right, depth+1, res);
        return revInorder(node.left, depth+1, res);
    }
}
