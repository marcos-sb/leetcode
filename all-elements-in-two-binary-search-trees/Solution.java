/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return merge(inOrder(root1, new ArrayList<>()), inOrder(root2, new ArrayList<>()));
    }
    
    private static List<Integer> inOrder(TreeNode node, List<Integer> inOrder) {
        if (node == null) return inOrder;
        inOrder(node.left, inOrder);
        inOrder.add(node.val);
        inOrder(node.right, inOrder);
        return inOrder;
    }
    
    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        final int totalsz = l1.size() + l2.size();
        final List<Integer> res = new ArrayList<>(totalsz);
        int i = 0;
        int j = 0;
        int k = 0;
        while (k++ < totalsz) {
            if (i >= l1.size()) { res.add(l2.get(j++)); }
            else if (j >= l2.size()) { res.add(l1.get(i++)); }
            else if (l1.get(i) <= l2.get(j)) { res.add(l1.get(i++)); }
            else { res.add(l2.get(j++)); }
        }
        return res;
    }
}
