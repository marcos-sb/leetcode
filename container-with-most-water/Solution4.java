class Solution {
    public int maxArea(int[] height) {
        final var n = height.length;
        var left = 0;
        var right = n - 1;

        var maxArea = 0;
        while (left < right) {
            var minHeight = Math.min(height[left], height[right]);
            var currArea = (right - left) * minHeight;
            maxArea = Math.max(currArea, maxArea);

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return maxArea;
    }
}
