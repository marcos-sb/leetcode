public class Solution {
    public String serialize(TreeNode root) {
        final StringBuilder sb = new StringBuilder();
        preorderSerialise(root, sb);
        return sb.toString();
    }

    private static void preorderSerialise(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(':');
            return;
        }
        sb.append(root.val).append(':');
        preorderSerialise(root.left, sb);
        preorderSerialise(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.charAt(0) == '#') return null;
        return preorderDeserialise(new LinkedList(Arrays.asList(data.split(":"))));
    }

    private static TreeNode preorderDeserialise(Queue<String> values) {
        final String val = values.poll();
        if (val.equals("#")) return null;
        
        final TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = preorderDeserialise(values);
        node.right = preorderDeserialise(values);
        
        return node;
    }
}
