class Solution {
    public int pathSum(TreeNode root, int sum) {
        return ps(root, sum, new ArrayList<>());
    }
    private int ps(TreeNode root, int sum, List<Integer> openPathsSum) {
        if (root == null) return 0;

        final var newPaths = new ArrayList<>(openPathsSum);
        for (int i = 0; i < newPaths.size(); i++)
            newPaths.set(i, newPaths.get(i)+root.val);
        newPaths.add(root.val);
        
        int count = 0;
        for (Integer n : newPaths)
            if (n.equals(sum)) count++;

        return count + ps(root.left, sum, newPaths) + ps(root.right, sum, newPaths);
    }
}
