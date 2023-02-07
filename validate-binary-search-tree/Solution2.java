class Solution {
    public boolean isValidBST(TreeNode root) {
        final var inOrder = new ArrayList<Integer>();
        inOrder(root, inOrder);
        return isSorted(inOrder);
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    private static boolean isSorted(List<Integer> list) {
        if (list == null || list.size() < 2) return true;
        for (var i = 1; i < list.size(); i++)
            if (list.get(i-1) >= list.get(i)) return false;
        return true;
    }
}
