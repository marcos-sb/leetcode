/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final Character NULL = '#';
    private static final Character EON = ':';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final var res = new StringBuilder();
        serHelper(root, res);
        return res.toString();
    }

    private void serHelper(TreeNode root, StringBuilder serial) {
        if (root == null) {
            serial.append(NULL);
            return;
        }
        serial.append(root.val);
        serial.append(EON);

        serHelper(root.left, serial);
        serHelper(root.right, serial);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deHelper(data.toCharArray(), new int[]{0});
    }

    private TreeNode deHelper(char[] data, int[] i) {
        if (data.length <= i[0]) {
            return null;
        }

        if (data[i[0]] == NULL) {
            ++i[0];
            return null;
        }

        final var val = readInt(data, i);
        final var root = new TreeNode(val);

        root.left = deHelper(data, i);
        root.right = deHelper(data, i);

        return root;
    }

    private int readInt(char[] data, int[] i) {
        var num = 0;
        var curr = 0;
        var sign = 1;

        if (data[i[0]] == '-') {
            sign = -1;
            ++i[0];
        }

        while ((curr = data[i[0]++]) != EON) {
            num = num*10 + curr-'0';
        }

        return sign * num;
    }
}
