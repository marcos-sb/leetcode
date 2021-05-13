public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) return nums.length;
        
        int dupCount = 0;
        int prev = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            final int curr = nums[i];
            if (prev == curr) dupCount++;
            else nums[j++] = curr;
            prev = curr;
        }

        return nums.length - dupCount;
    }
}
