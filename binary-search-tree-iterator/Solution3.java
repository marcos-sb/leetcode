class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if (!hasNext()) return -1;
        final var next = stack.pop();
        var node = next.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
