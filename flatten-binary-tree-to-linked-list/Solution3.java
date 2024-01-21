class Solution {
    // This solution is a bit 'magical'. The idea is to flatten the tree
    // progressively by finding the right-most node of the left subtree of
    // a given tree. Then, setting the right child of that node to be the
    // right child of the given tree root, and so on, until we reach the
    // end of the tree.
    // 
    // By doing this pointer rewiring we're essentially flattening as
    // much section of the given tree as possible each time without
    // having to use additional space to store nodes to visit in the
    // future -- like with both the recursive or stack-based approaches.
    public void flatten(TreeNode root) {
        var curr = root;
        while (curr != null) {
            var rightmost = curr.left;
            while (rightmost != null && rightmost.right != null)
                rightmost = rightmost.right;
            if (rightmost != null) {
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
