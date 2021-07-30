class Solution3 {
    public int trap(int[] height) {
        if (height == null) return 0;
        
        final int N = height.length;
        if (N < 3) return 0;
        
        int ans = 0;
        final Deque<Integer> st = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && height[i] > height[st.peekLast()]) {
                final int top = st.pollLast();
                if (st.isEmpty()) break;
                final int dist = i - st.peekLast() - 1;
                ans += dist * (Math.min(height[i], height[st.peekLast()]) - height[top]);
            }
            st.offerLast(i);
        }
        
        return ans;
    }
}
