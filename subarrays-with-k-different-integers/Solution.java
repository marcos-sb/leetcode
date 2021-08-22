class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return 0;
        
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }
    
    private static int atMostKDistinct(int[] nums, int k) {
        final var freq = new HashMap<Integer, Integer>();
        int l = 0;
        int count = 0;
        for (var r = 0; r < nums.length; r++) {
            if (freq.getOrDefault(nums[r], 0) == 0) k--;
            freq.put(nums[r], freq.getOrDefault(nums[r],0)+1);
            while (k < 0) {
                freq.put(nums[l], freq.get(nums[l])-1);
                if (freq.getOrDefault(nums[l], 0) == 0) k++;
                l++;
            }
            count += r-l+1;
        }
        
        return count;
    }
}
