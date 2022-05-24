class Solution {
    public int majorityElement(int[] nums) {
        var candidate = nums[0];
        var candidateCount = 1;
        for (var i = 1; i < nums.length; i++) {
            if (candidateCount == 0) candidate = nums[i];
            if (nums[i] == candidate) candidateCount++;
            else candidateCount--;
        }
        return candidate;
    }
}
