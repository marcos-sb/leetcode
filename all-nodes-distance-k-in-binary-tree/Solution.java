/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private final List<Integer> res;

    public Solution() {
        this.res = new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res.clear();
        dfs(root, target, k);
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int k) {
        if (root == null) return -1;

        if (root == target) {
            collectNodesAtDistance(root, k);
            return 0;
        }

        final var leftDistance = dfs(root.left, target, k);
        if (leftDistance != -1) {
            if (leftDistance + 1 == k) {
                res.add(root.val);
            } else if (leftDistance + 1 < k) {
                collectNodesAtDistance(root.right, k - leftDistance - 2);
            }
            return leftDistance + 1;
        }

        final var rightDistance = dfs(root.right, target, k);
        if (rightDistance != -1) {
            if (rightDistance + 1 == k) {
                res.add(root.val);
            } else if (rightDistance + 1 < k) {
                collectNodesAtDistance(root.left, k - rightDistance - 2);
            }
            return rightDistance + 1;
        }

        return -1;
    }

    private void collectNodesAtDistance(TreeNode root, int k) {
        if (root == null || k < 0) return;
        if (k == 0) {
            res.add(root.val);
            return;
        }

        collectNodesAtDistance(root.left, k-1);
        collectNodesAtDistance(root.right, k-1);
    }
}
