class Solution {
    public int maxArea(int[] height) {
        final var N = height.length;
        var i = 0;
        var j = N-1;
        var max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
            if (height[i] <= height[j]) i++;
            else j--;
        }
        
        return max;
    }
}
