class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final List<PriorityQueue<int[]>> left = new ArrayList<>();
        final List<PriorityQueue<int[]>> right = new ArrayList<>();
        
        vt(root, 0, 0, left, right);
        
        return buildResult(left, right);
    }
    
    private void vt(
        TreeNode node,
        int col, int row,
        List<PriorityQueue<int[]>> left,
        List<PriorityQueue<int[]>> right
    ) {
        if (node == null) return;
        
        final PriorityQueue<int[]> pq;
        if (col >= 0)
            pq = getPQ(col, right);
        else
            pq = getPQ(Math.abs(col)-1, left);
        
        pq.add(new int[]{row, node.val});
        
        vt(node.left, col-1, row+1, left, right);
        vt(node.right, col+1, row+1, left, right);
    }
    
    private static PriorityQueue<int[]> getPQ(int i, List<PriorityQueue<int[]>> side) {
        if (i >= side.size()) {
            side.add(new PriorityQueue<int[]>((a,b) -> {
                final var byRow = a[0] - b[0];
                if (byRow == 0) return a[1] - b[1]; // by value
                else return byRow;
            }));
        }
        return side.get(i);
    }
    
    private static List<List<Integer>> buildResult(
        List<PriorityQueue<int[]>> left,
        List<PriorityQueue<int[]>> right
    ) {
        final List<List<Integer>> ret = new ArrayList<>(left.size() + right.size());
        
        for (int i = left.size()-1; i >= 0; i--) {
            final var pq = left.get(i);
            final var l = new ArrayList<Integer>(pq.size());
            while (!pq.isEmpty()) {
                l.add(pq.poll()[1]);
            }
            ret.add(l);
        }
        for (var pq : right) {
            final var l = new ArrayList<Integer>(pq.size());
            while (!pq.isEmpty()) {
                l.add(pq.poll()[1]);
            }
            ret.add(l);
        }
        
        return ret;
    }
}
