class Solution {
    public int findPairs(int[] nums, int k) {
        final var abs2idx = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            abs2idx.put(nums[i]+k, i);
        
        final var used = new HashSet<Integer>();
        var pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            final var n = nums[i];
            if (used.contains(n)) continue;
            if (abs2idx.containsKey(n) && abs2idx.get(n) != i) {
                used.add(n);
                pairs++;
            }
        }
        
        return pairs;
    }
}
