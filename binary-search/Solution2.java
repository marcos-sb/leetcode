class Solution2 {
    public int search(int[] nums, int target) {
        if (nums == null) return -1;
        
        var left = 0;
        var right = nums.length-1;
        while (left <= right) {
            final var mid = (right - left) / 2 + left;
            if (nums[mid] < target) left = mid+1;
            else if (target < nums[mid]) right = mid-1;
            else return mid;
        }
        
        return -1;
    }
}
