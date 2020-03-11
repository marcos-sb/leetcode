package find_elements_in_a_contaminated_binary_tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    private final Set<Integer> els;

    public FindElements(TreeNode root) {
        els = new HashSet<>();
        root.val = 0;
        init(root);
    }

    private void init(TreeNode node) {
        if (node.left != null) {
            final int val = 2*node.val + 1;
            node.left.val = val;
            els.add(val);
            init(node.left);
        }
        if (node.right != null) {
            final int val = 2*node.val + 2;
            node.right.val = val;
            els.add(val);
            init(node.right);
        }
    }

    public boolean find(int target) {
        return els.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
