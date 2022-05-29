class Solution {
    public boolean increasingTriplet(int[] nums) {
        for (var i = 0; i < nums.length-2; i++)
            for (var j = i+1; j < nums.length-1; j++)
                for (var k = j+1; k < nums.length; k++)
                    if (nums[i] < nums[j] && nums[j] < nums[k]) return true;
        
        return false;
    }
}
