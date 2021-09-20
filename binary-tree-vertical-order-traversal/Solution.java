class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        final Map<Integer, List<Integer>> resMap = new HashMap<>();
        
        final var minIdx = levelOrder(root, resMap);
        
        final List<List<Integer>> res = new ArrayList<>();
        for (var i = minIdx; resMap.containsKey(i); i++) res.add(resMap.get(i));
        
        return res;
    }
    
    private static int levelOrder(TreeNode node, Map<Integer, List<Integer>> resMap) {
        if (node == null) return 0;
        
        final Map<TreeNode, Integer> idxMap = new HashMap<>();
        final var q = new LinkedList<TreeNode>();
        q.offer(node);
        idxMap.put(node, 0);
        var minIdx = 0;
        while (!q.isEmpty()) {
            final var cur = q.poll();
            final var curIdx = idxMap.get(cur);
            resMap.computeIfAbsent(curIdx, k -> new ArrayList<>()).add(cur.val);
            minIdx = Math.min(minIdx, curIdx);
            
            if (cur.left != null) {
                q.offer(cur.left);
                idxMap.put(cur.left, curIdx-1);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                idxMap.put(cur.right, curIdx+1);
            }
        }
        
        return minIdx;
    }
}
