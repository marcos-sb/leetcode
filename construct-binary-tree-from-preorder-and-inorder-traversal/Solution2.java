public class BuildTree {
    // The idea behind the solution:
    // - Each element in the pre-order array is the root of a subtree
    // - In the in-order array the elements to the left of a given element
    // are the values present in the left subtree, and the elements to its
    // right the values in the right subtree
    //
    // With those two observations we can build a recursive algorithm to
    // reconstruct the binary tree:
    // - Iterate the preorder list. Pick one element per recursive call
    // and make each the root of a new tree
    // - Find the element in the in-order array => the elements to its left
    // will be part of the left subtree, the elements to the right, part of
    // the right subtree
    // - Recursively build the left and subtrees
    // - Stop the recursion when we get out of bounds (hi < lo)
    // - Build/use a map to look up the index of an element the in-order
    // array in constant time
    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {
        final var N = pOrder.length;
        final var inOrder2Idx = new HashMap<Integer, Integer>();
        var i = 0;
        for (var in : iOrder) inOrder2Idx.put(in, i++);
        return aux(0, N-1, new int[]{0}, pOrder, iOrder, inOrder2Idx);
    }

    private static TreeNode<Integer> aux(int lo, int hi, int[] preIdx, int[] pre, int[] in, Map<Integer, Integer> inOrder2Idx) {
        if (hi < lo) return null;
        final var node = new TreeNode<>(pre[preIdx[0]]);
        final var inIdx = inOrder2Idx.get(pre[preIdx[0]]);
        preIdx[0]++;
        node.left = aux(lo, inIdx-1, preIdx, pre, in, inOrder2Idx);
        node.right = aux(inIdx+1, hi, preIdx, pre, in, inOrder2Idx);

        return node;
    }
}
