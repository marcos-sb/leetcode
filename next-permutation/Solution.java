class Solution {
    public void nextPermutation(int[] nums) {
        var i = nums.length-2;
        while (i >= 0 && nums[i+1] <= nums[i])
            i--;
        
        if (i >= 0) {
            var j = nums.length-1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i+1);
    }
    
    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private static void reverse(int[] nums, int from) {
        var i = from;
        var j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            j--;
            i++;
        }
    }
}
