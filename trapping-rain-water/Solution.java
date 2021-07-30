class Solution {
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length-1; i++) {
            int maxLeft = 0;
            for (int j = i-1; j >= 0; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            int maxRight = 0;
            for (int j = i+1; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            res += Math.max(Math.min(maxLeft, maxRight) - height[i], 0); 
        }
        return res;
    }
}
