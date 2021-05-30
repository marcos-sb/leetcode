class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return List.of();
        
        final var stack = new LinkedList<Node>();
        final var res = new ArrayList<Integer>();
        Node curr;
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            curr = stack.pollLast();
            res.add(curr.val);
            for (int i = curr.children.size()-1; i >= 0; i--) {
                stack.offerLast(curr.children.get(i));
            }
        }
        
        return res;
    }
}
