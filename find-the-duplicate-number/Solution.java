class Solution {
    public static int findDuplicate(int[] nums) {
        final var N = nums.length;
        var slow = nums[0];
        var fast = nums[0];
        do {
           slow = nums[slow];
           fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
           slow = nums[slow];
           fast = nums[fast];
        } 
        return fast;
   }
}