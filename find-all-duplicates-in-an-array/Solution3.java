class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        final var res = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            final int n = Math.abs(nums[i]);
            if (nums[n-1] < 0) res.add(n);
            else nums[n-1] = -nums[n-1];
        }
        return res;
    }
}
