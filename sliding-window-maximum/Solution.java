class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final var smap = new TreeMap<Integer, Integer>();
        int l = 0;
        int r = k-1;
        for (int i = l; i <= r; i++)
            smap.put(nums[i], smap.getOrDefault(nums[i], 0) + 1);
        
        final int[] res = new int[nums.length-k+1];
        res[0] = smap.lastKey();
        
        for (int i = 1; i < res.length; i++) {
            final int freq = smap.get(nums[l]);
            if (freq == 1) smap.remove(nums[l]);
            else smap.put(nums[l], freq-1);
            
            l++; r++;
            smap.put(nums[r], smap.getOrDefault(nums[r], 0) + 1);
            res[i] = smap.lastKey();
        }
        
        return res;
    }
}
