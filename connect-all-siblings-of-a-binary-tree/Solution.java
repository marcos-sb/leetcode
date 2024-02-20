public class ConnectAllSiblings{
    public static EduTreeNode<Integer> connectAllSiblings(EduTreeNode<Integer> root) {
        if (root == null) return null;

        final var q = new LinkedList<EduTreeNode<Integer>>();
        q.offer(root);
        while (!q.isEmpty()) {
            final var curr = q.poll();
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            if (!q.isEmpty()) curr.next = q.peek();
        }

        return root;
    }
}

