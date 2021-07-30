class Solution2 {
    public int trap(int[] height) {
        if (height == null) return 0;
        
        final int N = height.length;
        if (N < 3) return 0;
        
        final int[] leftMax = new int[N];
        leftMax[0] = height[0];
        for (int i = 1; i < N; i++)
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        
        final int[] rightMax = new int[N];
        rightMax[N-1] = height[N-1];
        for (int i = N-2; i >= 0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        
        int res = 0;
        for (int i = 1; i < N-1; i++)
            res += Math.max(Math.min(leftMax[i-1], rightMax[i+1]) - height[i], 0);
    
        return res;
    }
}
