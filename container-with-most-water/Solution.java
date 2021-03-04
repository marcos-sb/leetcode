class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxS = 0;
        while (i < j) {
            maxS = Math.max(maxS, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxS;
    }
}
