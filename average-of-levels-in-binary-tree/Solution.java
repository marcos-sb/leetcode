class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        final var levels = tlt(root, 0, new ArrayList<>());
        return levels.stream().map(Solution::avg).collect(Collectors.toList());
    }
    
    private static List<List<Integer>> tlt(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return res;
        
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        
        tlt(root.left, level+1, res);
        return tlt(root.right, level+1, res);
    }
    
    private static double avg(List<Integer> l) {
        long sum = 0;
        for (int n : l) sum += n;
        return sum / (double) l.size();
    }
}
