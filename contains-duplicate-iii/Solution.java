class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final long[][] numsIdx = new long[nums.length][2];
        for (var i = 0; i < nums.length; i++) {
            numsIdx[i][0] = nums[i]; numsIdx[i][1] = i;
        }
        
        Arrays.sort(numsIdx, (arr1,arr2) -> Arrays.compare(arr1,arr2));
        
        for (var i = 0; i < numsIdx.length-1; i++) {
            for (var j = i+1; j < numsIdx.length &&
                 Math.abs(numsIdx[i][0]-numsIdx[j][0]) <= t; j++) {
                
                if (Math.abs(numsIdx[i][1]-numsIdx[j][1]) <= k)
                    return true;
            }
        }
        
        return false;
    }
}
