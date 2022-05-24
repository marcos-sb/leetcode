class Solution {
    public int singleNumber(int[] nums) {
        var unique = 0;
        for (var num : nums)
            unique ^= num;
        return unique;
    }
}
