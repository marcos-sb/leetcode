class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        var left = 0;
        var right = nums.length-1;
        while (left < right) {
            final var mid = left + (right-left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return nums[left];
    }
}
