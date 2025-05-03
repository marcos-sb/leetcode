class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return List.of();
        return genTrees(1, n);
    }

    private static List<TreeNode> genTrees(int start, int end) {
        final var res = new ArrayList<TreeNode>();
        if (end < start) {
            res.add(null);
            return res;
        }

        for (var i = start; i <= end; ++i) {
            final var left = genTrees(start, i-1);
            final var right = genTrees(i+1, end);

            for (var l : left) {
                for (var r : right) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }

        return res;
    }
}
