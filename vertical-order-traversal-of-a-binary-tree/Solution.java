/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.SortedMap;
import java.util.AbstractMap;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        final var vLevels =
            new TreeMap<AbstractMap.SimpleImmutableEntry<Integer, Integer>, List<Integer>>(
                (p1,p2) -> {
                    final int da = Integer.compare(p1.getKey(),p2.getKey());
                    if (da != 0) return da;
                    return Integer.compare(p2.getValue(), p1.getValue());
                });
        
        vt(root, 0, 0, vLevels);
        
        final List<List<Integer>> res = new ArrayList<>();
        Integer lastX = Integer.MIN_VALUE;
        for (var entry : vLevels.entrySet()) {
            final var p = entry.getKey();
            final var l = entry.getValue();
            if (p.getKey() != lastX) {
                res.add(new ArrayList<>());
            }
            Collections.sort(l);
            res.get(res.size()-1).addAll(l);
            lastX = p.getKey();
        }
        
        return res;
    }
    private void vt(TreeNode node, int x, int y,
                    SortedMap<AbstractMap.SimpleImmutableEntry<Integer,Integer>, List<Integer>> vLevels) {
        if (node == null) return;
        vLevels.computeIfAbsent(new AbstractMap.SimpleImmutableEntry<>(x,y), __ -> new ArrayList<>()).add(node.val);
        vt(node.left, x-1, y-1, vLevels);
        vt(node.right, x+1, y-1, vLevels);
    }
}
