class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final var subtreeMap = new HashMap<String, Integer>();
        final var res = new ArrayList<TreeNode>();
        serialize(root, subtreeMap, res);
        return res;
    }

    private static String serialize(TreeNode root, Map<String, Integer> subtreeFreq, List<TreeNode> res) {
        if (root == null) return "#";

        final var left = serialize(root.left, subtreeFreq, res);
        final var right = serialize(root.right, subtreeFreq, res);

        final var subtree = root.val + "," + left + "," + right;
        subtreeFreq.put(subtree, subtreeFreq.getOrDefault(subtree, 0) + 1);

        if (subtreeFreq.get(subtree) == 2) res.add(root);

        return subtree;
    }
}
