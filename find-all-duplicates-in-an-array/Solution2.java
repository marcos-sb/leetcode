class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (nums[i]-1 != i && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
            i++;
        }
        
        final var res = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++)
            if (nums[j]-1 != j) res.add(nums[j]);
        
        return res;
    }
    private void swap(int[] nums, int a, int b) {
        final int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
