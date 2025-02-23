class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final var firstGreater = new int[10_0001];
        final var stack = new ArrayDeque<Integer>();
        for (var i = nums2.length-1; 0 <= i; i--) {
            final var n = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= n) {
                stack.pop();
            }
            if (stack.isEmpty()) firstGreater[n] = -1;
            else firstGreater[n] = stack.peek();
            stack.push(n);
        }

        final var res = new int[nums1.length];
        for (var i = 0; i < nums1.length; i++)
            res[i] = firstGreater[nums1[i]];

        return res;
    }
}
