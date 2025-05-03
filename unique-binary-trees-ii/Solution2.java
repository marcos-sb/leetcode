class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return List.of();
        return genTrees(1, n, new List[n+1][n+1]);
    }

    private List<TreeNode> genTrees(int start, int end, List<TreeNode>[][] memo) {
        final var res = new ArrayList<TreeNode>();
        if (end < start) {
            res.add(null);
            return res;
        }

        if (memo[start][end] != null) {
            return memo[start][end];
        }

        for (var i = start; i <= end; ++i) {
            final var left = genTrees(start, i-1, memo);
            final var right = genTrees(i+1, end, memo);

            for (var l : left) {
                for (var r : right) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }

        return memo[start][end] = res;
    }
}
