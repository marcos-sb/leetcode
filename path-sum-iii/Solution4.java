class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        final var counts = new HashMap<Long, Integer>();
        counts.put(0L, 1);
        return aux(root, targetSum, 0, counts);
    }

    private static int aux(TreeNode root, int target, long runningSum, Map<Long, Integer> counts) {
        if (root == null) return 0;
        runningSum += root.val;
        final var count = counts.getOrDefault(runningSum - target, 0);
        counts.put(runningSum, counts.getOrDefault(runningSum, 0) + 1);
        final var countLeft = aux(root.left, target, runningSum, counts);
        final var countRight = aux(root.right, target, runningSum, counts);
        counts.put(runningSum, counts.get(runningSum) - 1);
        runningSum -= root.val;
        return count + countLeft + countRight;
    }
}
