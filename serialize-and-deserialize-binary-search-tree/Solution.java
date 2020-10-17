public class Codec {
    class IntWrapper { // this to force java to pass instances of ints as a reference
        int i;
        IntWrapper(int i) {
            this.i = i;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final var sb = serialize(root, new StringBuilder());
        return sb.toString();
    }

    private static StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(':');
            return sb;
        }
        sb.append(node.val).append(':');
        serialize(node.left, sb);
        serialize(node.right, sb);
        
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data, new IntWrapper(0));
    }

    private static TreeNode deserialize(String data, IntWrapper iw) {
        if (iw.i == data.length()) return null;
        char c = data.charAt(iw.i++);
        if (c == ':') return null;
        final var sb = new StringBuilder();
        do {
            sb.append(c);
        } while (iw.i < data.length() && (c = data.charAt(iw.i++)) != ':');
        final var tn = new TreeNode(Integer.parseInt(sb.toString()));
        tn.left = deserialize(data, iw);
        tn.right = deserialize(data, iw);

        return tn;
    }
}
