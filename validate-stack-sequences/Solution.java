class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return vss(pushed, 0, popped, 0, new ArrayDeque<>());
    }
    
    private static boolean vss(int[] pushed, int i, int[] popped, int j, Deque<Integer> st) {
        if (i == pushed.length && j == popped.length)
            return true;
        
        var pop = false;
        if (!st.isEmpty() && j < popped.length && st.peekLast() == popped[j]) {
            st.pollLast();
            pop = vss(pushed, i, popped, j+1, st);
        }
        
        if (pop || i >= pushed.length) return pop;
        
        st.offerLast(pushed[i]);
        return vss(pushed, i+1, popped, j, st);
    }
}
