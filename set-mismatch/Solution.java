class Solution {
    public int[] findErrorNums(int[] nums) {
        final var set = new HashSet<Integer>();
        int dup = 0, mis = 0;
        
        for (int n : nums) if (!set.add(n)) dup = n;
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                mis = i;
                break;
            }
        }
        
        return new int[]{dup, mis};
    }
}
