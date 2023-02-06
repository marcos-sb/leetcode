class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return List.of();
        
        final var stack = new LinkedList<Node>();
        stack.push(root);

        final var res = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            final var cur = stack.pop();
            res.add(cur.val);
            for (var i = cur.children.size()-1; 0 <= i; i--)
                stack.push(cur.children.get(i));
        }

        return res;
    }
}
