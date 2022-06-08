class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, new ArrayList<>(), new ArrayList<>());
    }
    
    private static List<List<Integer>> dfs(TreeNode node, int left, List<Integer> open, List<List<Integer>> res) {
        if (node == null) return res;
        open.add(node.val);
        final var rem = left - node.val;
        if (rem == 0 && node.left == null && node.right == null)
            res.add(new ArrayList<>(open));
        
        dfs(node.left, rem, open, res);
        dfs(node.right, rem, open, res);
        open.remove(open.size()-1);
        
        return res;
    }
}
