public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        final var tree = new StringBuilder();
        final var node2id = new HashMap<TreeNode, Integer>();
        final var q = new LinkedList<TreeNode>();
        
        node2id.put(root, 0);
        q.offer(root);
        while (!q.isEmpty()) {
            final var curr = q.poll();
            tree.append(node2id.get(curr));
            tree.append(',');
            if (curr.left != null) {
                node2id.put(curr.left, node2id.size());
                tree.append(node2id.size()-1);
                q.offer(curr.left);
            }
            tree.append(',');
            if (curr.right != null) {
                node2id.put(curr.right, node2id.size());
                tree.append(node2id.size()-1);  
                q.offer(curr.right);
            }
            tree.append('|');
        }
        
        final var vals = new StringBuilder();
        for (var entry : node2id.entrySet())
            vals.append(entry.getValue())
                .append(':')
                .append(entry.getKey().val)
                .append('|');
        
        return vals.append('\n')
                   .append(tree)
                   .append('\n').toString();
    }

    // Decodes your encoded data to tree.
    // id:val|id:val|...\nroid,lid,rid|roid,lid,rid|...\n
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        
        var i = 0;
        final var id2node = new HashMap<Integer, TreeNode>();
        while (data.charAt(i) != '\n') {
            var j = data.indexOf(':', i);
            final var id = Integer.parseInt(data.substring(i, j));
            i = j+1;
            j = data.indexOf('|', i);
            final var val = Integer.parseInt(data.substring(i, j));
            i = j+1;
            id2node.put(id, new TreeNode(val));
        }
        i++;
        
        TreeNode root = null;
        while(data.charAt(i) != '\n') {
            var j = data.indexOf(',', i);
            final var node = id2node.get(Integer.parseInt(data.substring(i, j)));
            i = j+1;
            j = data.indexOf(',', i);
            final var left = i == j ? null : id2node.get(Integer.parseInt(data.substring(i, j)));
            i = j+1;
            j = data.indexOf('|', i);
            final var right = i == j ? null : id2node.get(Integer.parseInt(data.substring(i, j)));
            i = j+1;
            node.left = left;
            node.right = right;
            
            if (root == null) root = node;
        }
        
        return root;
    }
}
