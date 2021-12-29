class Solution2 {
    public void sortColors(int[] nums) {
        var p0 = 0;
        var p2 = nums.length-1;
        var cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) swap(nums, p0++, cur++);
            else if (nums[cur] == 2) swap(nums, p2--, cur);
            else cur++;
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
