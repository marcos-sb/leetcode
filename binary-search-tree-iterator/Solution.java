class BSTIterator {
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        traverseToLeftMost(root);
    }

    private void traverseToLeftMost(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        if (stack.isEmpty()) return -1;
        final var ret = stack.peek();
        TreeNode node = stack.pop().right;
        traverseToLeftMost(node);
        return ret.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
