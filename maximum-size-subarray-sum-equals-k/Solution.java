public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) maxLen = Math.max(maxLen, 1);
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}
