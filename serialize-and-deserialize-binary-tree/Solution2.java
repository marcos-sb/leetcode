public class Codec {
    // This solution implements a binary tree ser/de using
    // BFS traversal (preorder + queue), and a dummy tree node
    // as a placeholder for null children.
    //
    private static final char DELIM = ':';
    private int _i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { // O(N)
        if (root == null) return "";
        final var q = new ArrayDeque<TreeNode>();
        q.offer(root);
        final var sb = new StringBuilder();
        final var dummy = new TreeNode(-1001);
        while (!q.isEmpty()) {
            final var curr = q.poll();
            if (curr != dummy) {
                if (curr.left == null) q.offer(dummy);
                else q.offer(curr.left);
                if (curr.right == null) q.offer(dummy);
                else q.offer(curr.right);
                sb.append(curr.val);
            }
            sb.append(DELIM);
        }
        final var S = sb.length();
        var i = S-1;
        while (0 <= i && sb.charAt(i) == DELIM) i--;
        sb.setLength(i+1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // O(S)
        if (data.isEmpty()) return null;
        final var q = new ArrayDeque<TreeNode>();
        final var rootVal = readInt(data);
        final var root = new TreeNode(rootVal);
        q.offer(root);
        while (_i < data.length() && !q.isEmpty()) {
            final var curr = q.poll();
            final var valLeft = readInt(data);
            if (valLeft != null) {
                curr.left = new TreeNode(valLeft);
                q.offer(curr.left);
            }
            final var valRight = readInt(data);
            if (valRight != null) {
                curr.right = new TreeNode(valRight);
                q.offer(curr.right);
            }
        }

        return root;
    }

    private Integer readInt(String data) {
        if (data.length() <= _i) return null;
        if (data.charAt(_i) == DELIM) {
            _i++;
            return null;
        }
        var res = 0;
        var sign = 1;
        while (_i < data.length() && data.charAt(_i) != DELIM) {
            if (data.charAt(_i) == '-') sign = -1;
            else res = res * 10 + data.charAt(_i)-'0';
            _i++;
        }
        if (_i < data.length()) _i++;
        return res * sign;
    }
}
