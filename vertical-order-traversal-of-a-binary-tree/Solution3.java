class Solution {
    // col => [(row, value)]
    private final Map<Integer, List<Pair<Integer, Integer>>> col2rowvals;
    private int minCol;
    private int maxCol;

    public Solution() {
        col2rowvals = new HashMap<>();
        minCol = 0;
        maxCol = 0;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0); // O(N)

        final List<List<Integer>> res = new ArrayList<>(maxCol-minCol+1);
        for (var col = minCol; col <= maxCol; col++) {
            final var lp = col2rowvals.get(col);
            Collections.sort(lp, (p1, p2) -> { // O(k/N * log(k/N)), k: number of vertical partitions, k/N: avg size of each partition
                final var rowCmp = Integer.compare(p1.getKey(), p2.getKey());
                return rowCmp != 0 ? rowCmp : Integer.compare(p1.getValue(), p2.getValue());
            });
            final var colTraversal = new ArrayList<Integer>(lp.size());
            for (var p : lp) colTraversal.add(p.getValue()); // O(k/N)
            res.add(colTraversal);
        }

        return res;
    }

    private void dfs(TreeNode node, int r, int c) {
        if (node == null) return;

        col2rowvals.computeIfAbsent(c, k -> new ArrayList<>()).add(new Pair<>(r, node.val));
        minCol = Math.min(minCol, c);
        maxCol = Math.max(maxCol, c);

        dfs(node.left, r+1, c-1);
        dfs(node.right, r+1, c+1);
    }
}
