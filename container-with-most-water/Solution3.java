class Solution {
    public int maxArea(int[] height) {
        final var N = height.length;
        var i = 0;
        var j = N-1;
        var max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
            if (height[i] <= height[j]) {
                final var hi = height[i];
                while (i < j && height[i] <= hi) i++;
            } else {
                final var hj = height[j];
                while (i < j && height[j] <= hj) j--;
            }
        }
        
        return max;
    }
}
