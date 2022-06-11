class BSTIterator {
    private final Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        final var dummy = new TreeNode(-1);
        dummy.right = root;
        stack = new ArrayDeque<>();
        stack.push(dummy);
    }
    
    public int next() {
        final var top = stack.pop();
        var curr = top.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return stack.peek().val;
    }
    
    public boolean hasNext() {
        return 1 < stack.size() || (!stack.isEmpty() && stack.peek().right != null);
    }
}
