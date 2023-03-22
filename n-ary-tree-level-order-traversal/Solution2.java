class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return List.of();
        final List<List<Integer>> res = new ArrayList<>();
        lvlOrder(root, 0, res);
        return res;
    }

    private static void lvlOrder(Node root, int level, List<List<Integer>> res) {
        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        for (var c : root.children) lvlOrder(c, level+1, res);
    }
}
