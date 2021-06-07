class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSumRec(root, 0, targetSum, new HashMap<>());
    }
    
    private static int pathSumRec(TreeNode node, int runningSum, int target, Map<Integer, Integer> pathSums) {
        if (node == null) return 0;

        int count = 0;
        int sum = runningSum + node.val;
        if (sum == target) count++;
        count += pathSums.getOrDefault(sum-target, 0);

        pathSums.put(sum, pathSums.getOrDefault(sum, 0) + 1);
        count += pathSumRec(node.left, sum, target, pathSums);
        count += pathSumRec(node.right, sum, target, pathSums);
        pathSums.put(sum, pathSums.get(sum)-1);

        return count;
    }
}
