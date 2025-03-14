class Solution {
    private int id;
    private final Map<String, Integer> serial2Id;
    private final Map<Integer, Integer> subtreeFreq;

    public Solution() {
        id = 0;
        serial2Id = new HashMap<>();
        subtreeFreq = new HashMap<>();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        final var subtreeMap = new HashMap<String, Integer>();
        final var res = new ArrayList<TreeNode>();
        lookup(root, res);
        return res;
    }

    private int lookup(TreeNode root, List<TreeNode> res) {
        if (root == null) return 0;

        final var left = lookup(root.left, res);
        final var right = lookup(root.right, res);

        final var serial = root.val + "," + left + "," + right;
        final var _id = serial2Id.computeIfAbsent(serial, __ -> ++id);
        subtreeFreq.put(_id, subtreeFreq.getOrDefault(_id, 0) + 1);

        if (subtreeFreq.get(_id) == 2) res.add(root);

        return _id;
    }
}
