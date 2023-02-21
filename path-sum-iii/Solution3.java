class Solution {
    private HashMap<Long, Integer> seen;
    private long runningSum;
    private int count;
    
    public Solution() {
        seen = new HashMap<>();
        runningSum = 0;
        count = 0;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return count;
        runningSum += root.val;
        if (runningSum == targetSum) count++;
        count += seen.getOrDefault(runningSum - targetSum, 0);
        seen.merge(runningSum, 1, Integer::sum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        seen.compute(runningSum, (k,v) -> v == 1 ? null : v-1);
        runningSum -= root.val;
        return count;
    }
}
